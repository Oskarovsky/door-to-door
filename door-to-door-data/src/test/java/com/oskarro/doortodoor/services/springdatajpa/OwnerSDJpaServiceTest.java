package com.oskarro.doortodoor.services.springdatajpa;

import com.oskarro.doortodoor.model.Owner;
import com.oskarro.doortodoor.repositories.OwnerRepository;
import com.oskarro.doortodoor.repositories.ProductRepository;
import com.oskarro.doortodoor.repositories.ProductTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

// setting up JUnit5 environment for Mockito
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";

    // added repositories from original class below

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    ProductRepository productRepository;

    @Mock
    ProductTypeRepository productTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    // reset before each test method
    // if object has changed at any point in a test, the next test would get a fresh object (SAFETY THING)
    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = service.findByLastName(LAST_NAME);  // if it works - mockito is running properly

        assertEquals(LAST_NAME, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {

        // added 2 owners to the list
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    // when repository find object by iD
    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    // when repository doesn't find anything
    @Test
    void findByIdNotFound() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {

        // creating owner
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {

        service.delete(returnOwner);

        // default is 1 times (verify the mock and number times)
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {

        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}