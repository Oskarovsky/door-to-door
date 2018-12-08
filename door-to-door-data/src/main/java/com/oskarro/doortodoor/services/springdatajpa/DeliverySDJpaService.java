package com.oskarro.doortodoor.services.springdatajpa;

import com.oskarro.doortodoor.model.Delivery;
import com.oskarro.doortodoor.repositories.DeliveryRepository;
import com.oskarro.doortodoor.services.DeliveryService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class DeliverySDJpaService implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliverySDJpaService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Set<Delivery> findAll() {
        Set<Delivery> deliveries = new HashSet<>();
        deliveryRepository.findAll().forEach(deliveries::add);
        return deliveries;
    }

    @Override
    public Delivery findById(Long aLong) {
        return deliveryRepository.findById(aLong).orElse(null);
    }

    @Override
    public Delivery save(Delivery object) {
        return deliveryRepository.save(object);
    }

    @Override
    public void delete(Delivery object) {
        deliveryRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        deliveryRepository.deleteById(aLong);
    }
}
