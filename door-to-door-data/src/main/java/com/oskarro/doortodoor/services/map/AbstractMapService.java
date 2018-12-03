package com.oskarro.doortodoor.services.map;

import com.oskarro.doortodoor.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }


    // return back the Type
    T findById(ID id) {
        return map.get(id);
    }


    // return back the type
    // just object beacuse we don;t know what's coming on because of the generics
    T save(T object) {

        if(object != null) {
            if(object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }


    // just removes from the map
    void deleteById(ID id) {
        map.remove(id);
    }


    // Lambda 8 (only for Java 8)
    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }


    // Creating new IDs number (max_length + 1)
    private Long getNextId() {

        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {    // for the first element in DB
            nextId = 1L;
        }

        return nextId;
    }
}