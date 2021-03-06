package com.oskarro.doortodoor.services.map;

import com.oskarro.doortodoor.model.Delivery;
import com.oskarro.doortodoor.services.DeliveryService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class DeliveryMapService extends AbstractMapService<Delivery, Long> implements DeliveryService {

    @Override
    public Set<Delivery> findAll() {
        return super.findAll();
    }

    @Override
    public Delivery findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Delivery save(Delivery delivery) {

        if(delivery.getCourier() == null || delivery.getCourier().getId() == null) {
            throw new RuntimeException("Invalid Delivery");
        }

        return super.save(delivery);
    }

    @Override
    public void delete(Delivery object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
