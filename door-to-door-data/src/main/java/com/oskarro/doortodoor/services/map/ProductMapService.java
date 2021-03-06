package com.oskarro.doortodoor.services.map;

import com.oskarro.doortodoor.model.Product;
import com.oskarro.doortodoor.services.ProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class ProductMapService extends AbstractMapService<Product, Long> implements ProductService {

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
        return super.save(object);
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
