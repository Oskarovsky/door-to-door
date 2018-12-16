package com.oskarro.doortodoor.formatters;

import com.oskarro.doortodoor.model.ProductType;
import com.oskarro.doortodoor.services.ProductTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

// this will be used by Spring MVC

@Component
public class ProductTypeFormatter implements Formatter<ProductType> {

    private final ProductTypeService productTypeService;

    public ProductTypeFormatter(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @Override
    public String print(ProductType productType, Locale locale) {
        return productType.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        // pull out a collection and iterate over it
        Collection<ProductType> findProductTypes = productTypeService.findAll();

        // it;s going to iterate over the list of all product types and then get the name and return that
        for (ProductType type : findProductTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("type not found: " + text, 0);
    }
}
