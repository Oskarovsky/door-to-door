package com.oskarro.doortodoor.services.map;

import com.oskarro.doortodoor.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapServiceTest {

    private ProductMapService productMapService;

    private final Long productId = 1L;


    @BeforeEach
    void setUp() {
        productMapService = new ProductMapService();
        productMapService.save(Product.builder().id(productId).build());
    }

    @Test
    void findAll() {
        Set<Product> productSet = productMapService.findAll();
        assertEquals(1, productSet.size());
    }

    @Test
    void findByIdExistingId() {
        Product product = productMapService.findById(productId);
        assertEquals(productId, product.getId());
    }

    @Test
    void findByIdNotExistingId() {
        Product product = productMapService.findById(5L);
        assertNull(product);
    }

    @Test
    void findByIdNullId() {
        Product product = productMapService.findById(null);
        assertNull(product);
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Product product2 = Product.builder().id(id).build();
        Product savedProduct = productMapService.save(product2);
        assertEquals(id, savedProduct.getId());
    }

    @Test
    void saveDuplicateId() {
        Long id = 1L;
        Product product2 = Product.builder().id(id).build();
        Product savedProduct = productMapService.save(product2);
        assertEquals(id, savedProduct.getId());
        assertEquals(1, productMapService.findAll().size());
    }

    @Test
    void saveNoId() {
        Product savedProduct = productMapService.save(Product.builder().build());
        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());
        assertEquals(2, productMapService.findAll().size());
    }

    @Test
    void deleteProduct() {
        productMapService.delete(productMapService.findById(productId));
        assertEquals(0, productMapService.findAll().size());
    }

    @Test
    void deleteWithWrongId() {
        Product product = Product.builder().id(5L).build();
        productMapService.delete(product);
        assertEquals(1, productMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {
        Product product = Product.builder().build();
        productMapService.delete(product);
        assertEquals(1, productMapService.findAll().size());
    }

    @Test
    void deleteNull() {
        productMapService.delete(null);
        assertEquals(1, productMapService.findAll().size());
    }

    @Test
    void deleteByIdCorrectId() {
        productMapService.deleteById(productId);
        assertEquals(0, productMapService.findAll().size());
    }

    @Test
    void deleteByWrongId() {
        productMapService.deleteById(5L);
        assertEquals(1, productMapService.findAll().size());
    }

    @Test
    void deleteByNullId() {
        productMapService.deleteById(null);
        assertEquals(1, productMapService.findAll().size());
    }
}