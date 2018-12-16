package com.oskarro.doortodoor.controllers;

import com.oskarro.doortodoor.services.OwnerService;
import com.oskarro.doortodoor.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    ProductService productService;

    @Mock
    OwnerService ownerService;

    @BeforeEach
    void setUp() {
    }
}