package com.oskarro.doortodoor.services.map;

import com.oskarro.doortodoor.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

// FULL CRUD Test for Owner Map Service

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    // good habit (for replacing this)
    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new ProductTypeMapService(), new ProductMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());   // saving Owner like so
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {

        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {

        // deleting by the object
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());  // this should return back 0
    }

    @Test
    void deleteById() {

        // deleting by the ID
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {

        Owner smith = ownerMapService.findByLastName(lastName);

        assertNotNull(smith);

        assertEquals(ownerId, smith.getId());
    }

    @Test
    void findByLastNameNotFound() {

        Owner smith = ownerMapService.findByLastName("foo");

        assertNull(smith);
    }
}