package com.oskarro.doortodoor.services;

import com.oskarro.doortodoor.model.Courier;

import java.util.Set;

public interface CourierService {

    Courier findById(Long id);

    Courier save(Courier courier);

    Set<Courier> findAll();
}
