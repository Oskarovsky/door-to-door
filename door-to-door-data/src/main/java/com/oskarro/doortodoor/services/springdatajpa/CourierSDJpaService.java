package com.oskarro.doortodoor.services.springdatajpa;

import com.oskarro.doortodoor.model.Courier;
import com.oskarro.doortodoor.repositories.CourierRepository;
import com.oskarro.doortodoor.services.CourierService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class CourierSDJpaService implements CourierService {

    private final CourierRepository courierRepository;

    public CourierSDJpaService(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    @Override
    public Set<Courier> findAll() {
        Set<Courier> couriers = new HashSet<>();
        courierRepository.findAll().forEach(couriers::add);
        return couriers;
    }

    @Override
    public Courier findById(Long aLong) {
        return courierRepository.findById(aLong).orElse(null);
    }

    @Override
    public Courier save(Courier object) {
        return courierRepository.save(object);
    }

    @Override
    public void delete(Courier object) {
        courierRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        courierRepository.deleteById(aLong);
    }
}
