package com.oskarro.doortodoor.controllers;

import com.oskarro.doortodoor.model.Owner;
import com.oskarro.doortodoor.model.Product;
import com.oskarro.doortodoor.model.ProductType;
import com.oskarro.doortodoor.services.OwnerService;
import com.oskarro.doortodoor.services.ProductService;
import com.oskarro.doortodoor.services.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @ModelAttribute("owner")
    public Owner findOwner (@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }


    @InitBinder("owner")
    public void initOwnerBinder (WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


    // initializer which is going to return back an empty object to model
    // that displays form properly and the bind variables
    @GetMapping("/products/new")
    public String initCreationForm(Owner owner, Model model) {
        Product product = new Product();
        owner.getProducts().add(product);
        product.setOwner(owner);
        model.addAttribute("product", product);
        return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
    }


    // form will get posted and that method handles that post
    @PostMapping("/products/new")
    public String processCreationForm(Owner owner, @Valid Product product, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(product.getName())
                && product.isNew()
                && owner.getProduct(product.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        product.setOwner(owner);
        owner.getProducts().add(product);
        if (result.hasErrors()) {
            model.put("product", product);
            return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
        } else {
            productService.save(product);
            return "redirect:/owners/" + owner.getId();
        }
    }


    // initializer which is going to return back an empty object to model
    // that displays form properly and the bind variables
    // it is going to provide a populated product object back to the model
    @GetMapping("products/{productId}/edit")
    public String initUpdateForm(@PathVariable Long productId, Model model) {
        model.addAttribute("product", productService.findById(productId));
        return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
    }


    // form will get posted and that method handles that post
    // for accepting product object back and save that
    @PostMapping("/products/{productId}/edit")
    public String processUpdateForm(@Valid Product product, BindingResult result, Owner owner, Model model) {
        product.setOwner(owner);
        if (result.hasErrors()) {
            model.addAttribute("product", product);
            return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
        } else {
            Product managedProduct = productService.save(product);
            owner.getProducts().add(managedProduct);
            return "redirect:/owners/" + owner.getId();
        }
    }


}
