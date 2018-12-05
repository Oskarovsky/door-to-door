package com.oskarro.doortodoor.services.map;

import com.oskarro.doortodoor.model.ProductType;
import com.oskarro.doortodoor.services.ProductTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductTypeMapService extends AbstractMapService<ProductType, Long>  implements ProductTypeService {

    @Override
    public Set<ProductType> findAll() {
        return super.findAll();
    }

    @Override
    public ProductType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public ProductType save(ProductType object) {
        return super.save(object);
    }

    @Override
    public void delete(ProductType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.findById(id);
    }
}
