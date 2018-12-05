package com.oskarro.doortodoor.services.map;

import com.oskarro.doortodoor.model.Courier;
import com.oskarro.doortodoor.model.Speciality;
import com.oskarro.doortodoor.services.CourierService;
import com.oskarro.doortodoor.services.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CourierServiceMap extends AbstractMapService<Courier, Long> implements CourierService {

    private final SpecialityService specialityService;

    public CourierServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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

        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
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
