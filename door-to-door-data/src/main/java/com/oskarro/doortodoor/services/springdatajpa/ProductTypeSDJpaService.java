package com.oskarro.doortodoor.services.springdatajpa;

import com.oskarro.doortodoor.model.ProductType;
import com.oskarro.doortodoor.repositories.ProductTypeRepository;
import com.oskarro.doortodoor.services.ProductTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class ProductTypeSDJpaService implements ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    public ProductTypeSDJpaService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public Set<ProductType> findAll() {
        Set<ProductType> productTypes = new HashSet<>();
        productTypeRepository.findAll().forEach(productTypes::add);
        return productTypes;
    }

    @Override
    public ProductType findById(Long aLong) {
        return productTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public ProductType save(ProductType object) {
        return productTypeRepository.save(object);
    }

    @Override
    public void delete(ProductType object) {
        productTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        productTypeRepository.deleteById(aLong);
    }
}
