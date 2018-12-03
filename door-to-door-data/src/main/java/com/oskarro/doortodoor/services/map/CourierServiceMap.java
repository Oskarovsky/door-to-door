package com.oskarro.doortodoor.services.map;

import com.oskarro.doortodoor.model.Courier;
import com.oskarro.doortodoor.services.CourierService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CourierServiceMap extends AbstractMapService<Courier, Long> implements CourierService {

    @Override
    public Set<Courier> findAll() {
        return super.findAll();
    }

    @Override
    public Courier findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Courier save(Courier object) {
        return super.save(object);
    }

    @Override
    public void delete(Courier object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
