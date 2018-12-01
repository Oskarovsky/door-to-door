package com.oskarro.doortodoor.services;

import com.oskarro.doortodoor.model.Product;

import java.util.Set;

public interface ProductService {

    Product findById(Long id);

    Product save(Product product);

    Set<Product> findAll();
}
