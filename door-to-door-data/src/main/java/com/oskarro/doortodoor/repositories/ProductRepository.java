package com.oskarro.doortodoor.repositories;

import com.oskarro.doortodoor.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
