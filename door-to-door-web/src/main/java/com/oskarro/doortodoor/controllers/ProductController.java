package com.oskarro.doortodoor.controllers;

import com.oskarro.doortodoor.model.Owner;
import com.oskarro.doortodoor.model.ProductType;
import com.oskarro.doortodoor.services.OwnerService;
import com.oskarro.doortodoor.services.ProductService;
import com.oskarro.doortodoor.services.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class ProductController {

    private static final String VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";

    private final ProductService productService;
    private final OwnerService ownerService;
    private final ProductTypeService productTypeService;

    public ProductController(ProductService productService, OwnerService ownerService, ProductTypeService productTypeService) {
        this.productService = productService;
        this.ownerService = ownerService;
        this.productTypeService = productTypeService;
    }

    // we're gonna get a collection of a product types to types
    @ModelAttribute("types")
    public Collection<ProductType> populateProductTypes() {
        return productTypeService.findAll();
    }

    // putting found products to list
    @ModelAttribute("owners")
    public Owner findOwner (@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @ModelAttribute("owner")
    public void initOwnerBinder (WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}
