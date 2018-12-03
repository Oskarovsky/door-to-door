package com.oskarro.doortodoor.services.map;

import com.oskarro.doortodoor.model.Product;
import com.oskarro.doortodoor.services.ProductService;

import java.util.Set;

public class ProductServiceMap extends AbstractMapService<Product, Long> implements ProductService {

    @Override
    public Set<Product> findAll() {
        return super.findAll();
    }

    @Override
    public Product findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Product save(Product object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Product object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
