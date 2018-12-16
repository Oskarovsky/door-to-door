package com.oskarro.doortodoor.controllers;

import com.oskarro.doortodoor.model.Owner;
import com.oskarro.doortodoor.model.Product;
import com.oskarro.doortodoor.model.ProductType;
import com.oskarro.doortodoor.services.OwnerService;
import com.oskarro.doortodoor.services.ProductService;
import com.oskarro.doortodoor.services.ProductTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    ProductService productService;

    @Mock
    OwnerService ownerService;

    @Mock
    ProductTypeService productTypeService;

    @InjectMocks
    ProductController productController;

    MockMvc mockMvc;

    Owner owner;
    Set<ProductType> productTypes;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1l).build();

        productTypes = new HashSet<>();
        productTypes.add(ProductType.builder().id(1L).name("Car").build());
        productTypes.add(ProductType.builder().id(2L).name("Animal").build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(productController)
                .build();
    }

    // initializer which is going to return back an empty object to model
    // that displays form properly and the bind variables
    @Test
    void initCreationForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(productTypeService.findAll()).thenReturn(productTypes);


        mockMvc.perform(get("/owners/1/products/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("product"))
                .andExpect(view().name("products/createOrUpdateProductForm"));
    }

    // form will get posted and that method handles that post
    @Test
    void processCreationForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(productTypeService.findAll()).thenReturn(productTypes);

        mockMvc.perform(post("/owners/1/products/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(productService).save(any());
    }

    // initializer which is going to return back an empty object to model
    // that displays form properly and the bind variables
    // it is going to provide a populated product object back to the model
    @Test
    void initUpdateForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(productTypeService.findAll()).thenReturn(productTypes);
        when(productService.findById(anyLong())).thenReturn(Product.builder().id(2L).build());

        mockMvc.perform(get("/owners/1/products/2/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("product"))
                .andExpect(view().name("products/createOrUpdateProductForm"));
    }

    // form will get posted and that method handles that post
    // for accepting product object back and save that
    @Test
    void processUpdateForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(productTypeService.findAll()).thenReturn(productTypes);

        mockMvc.perform(post("/owners/1/products/2/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(productService).save(any());
    }

    @Test
    void populateProductTypes() {
        // todo impl
    }

    @Test
    void findOwner() {
        // todo impl
    }

    @Test
    void initOwnerBinder() {
        // todo impl
    }
}