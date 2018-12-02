package com.oskarro.doortodoor.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    // return back the Type
    T findById(ID id) {
        return map.get(id);
    }

    // return back the type
    // just object beacuse we don;t know what's coming on because of the generics
    T save(ID id, T object) {
        map.put(id, object);

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
}