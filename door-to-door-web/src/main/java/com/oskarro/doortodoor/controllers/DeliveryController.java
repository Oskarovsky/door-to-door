package com.oskarro.doortodoor.controllers;

import com.oskarro.doortodoor.model.Delivery;
import com.oskarro.doortodoor.model.Product;
import com.oskarro.doortodoor.services.DeliveryService;
import com.oskarro.doortodoor.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class DeliveryController {

    private final DeliveryService deliveryService;
    private final ProductService productService;

    // autowired by constructor
    public DeliveryController(DeliveryService deliveryService, ProductService productService) {
        this.deliveryService = deliveryService;
        this.productService = productService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    // model attribute is going to run with every request against this controller
    @ModelAttribute("delivery")
    public Delivery loadProductWithDelivery(@PathVariable("productId") Long productId, Map<String, Object> model) {
        Product product = productService.findById(productId);
        model.put("product", product);
        Delivery delivery = new Delivery();
        product.getDeliveries().add(delivery);
        delivery.setProduct(product);
        return delivery;
    }

    // loading deliveries and then return back
    // initialising new delivery form
    // Spring MVC calls method loadProductWithDelivery(...) before initNewDeliveryForm is called
    @GetMapping("/owners/*/products/{productId}/deliveries/new")
    public String initNewDeliveryForm(@PathVariable("productId") Long productId, Map<String, Object> model) {
        return "products/createOrUpdateDeliveryForm";
    }

    // handling the post
    // Spring MVC calls method loadProductWithDelivery(...) before processNewDeliveryForm is called
    @PostMapping("/owners/{ownerId}/products/{productId}/deliveries/new")
    public String processNewDeliveryForm(@Valid Delivery delivery, BindingResult result) {
        // we are going to make sure that the delivery is valid
        if (result.hasErrors()) {
            return "products/createOrUpdateDeliveryForm";   // if not valid return back
        } else {
            deliveryService.save(delivery);
            return "redirect:/owners/{ownerId}";                      // if valid save the delivery
        }
    }
}
