package com.oskarro.doortodoor.services;

import java.util.Set;

// all our service interfaces are going to inherit these methods
public interface CrudService<T, ID> {

    // Returns all instances of the type
    Set<T> findAll();

    // Returns all instances of the type with the given IDs
    T findById(ID id);

    // Saves a given entity
    T save(T object);

    // Deletes a given entity
    void delete(T object);

    // Deletes the entity with the given id
    void deleteById(ID id);

}
