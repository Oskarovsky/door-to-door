package com.oskarro.doortodoor.controllers;

import com.oskarro.doortodoor.model.Owner;
import com.oskarro.doortodoor.model.Product;
import com.oskarro.doortodoor.model.ProductType;
import com.oskarro.doortodoor.services.DeliveryService;
import com.oskarro.doortodoor.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class DeliveryControllerTest {

    private final String PRODUCTS_CREATE_OR_UPDATE_DELIVERY_FORM = "products/createOrUpdateDeliveryForm";
    private final String REDIRECT_OWNERS_1 = "redirect:/owners/{ownerId}";
    private final String YET_ANOTHER_DELIVERY_DESCRIPTION = "yet another delivery";

    @Mock
    ProductService productService;

    @Mock
    DeliveryService deliveryService;

    @InjectMocks
    DeliveryController deliveryController;

    private MockMvc mockMvc;

    private final UriTemplate deliveriesUriTemplate =
            new UriTemplate("/owners/{ownerId}/products/{productId}/deliveries/new");
    private final Map<String, String> uriVariables = new HashMap<>();
    private URI deliveriesUri;

    @BeforeEach
    void setUp() {
        Long productId = 1L;
        Long ownerId = 1L;
        when(productService.findById(anyLong()))
                .thenReturn(
                        Product.builder()
                            .id(productId)
                            .name("audi")
                            .deliveries(new HashSet<>())
                            .description("very nice car")
                            .size("160x220, 1500kg")
                            .price("500000pln")
                            .imageUrl("http://www.oski.com")
                            .endLocalization("Gdansk")
                            .startLocalization("Warsaw")
                            .owner(Owner.builder()
                                .id(ownerId)
                                .lastName("Doe")
                                .firstName("Joe")
                                .build())
                            .productType(ProductType.builder()
                                .name("Car").build())
                            .build()
                );

        uriVariables.clear();
        uriVariables.put("ownerId", ownerId.toString());
        uriVariables.put("productId", productId.toString());
        deliveriesUri = deliveriesUriTemplate.expand(uriVariables);

        mockMvc = MockMvcBuilders
                .standaloneSetup(deliveryController)
                .build();
    }

    @Test
    void initNewDeliveryForm() throws Exception {
        mockMvc.perform(get(deliveriesUri))
                .andExpect(status().isOk())
                .andExpect(view().name(PRODUCTS_CREATE_OR_UPDATE_DELIVERY_FORM));
    }

    @Test
    void processNewDeliveryForm() throws Exception {
        mockMvc.perform(post(deliveriesUri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("date","2018-11-11")
                .param("description", YET_ANOTHER_DELIVERY_DESCRIPTION))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name(REDIRECT_OWNERS_1))
                .andExpect(model().attributeExists("delivery"));
    }
}
