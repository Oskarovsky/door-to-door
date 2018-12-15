package com.oskarro.doortodoor.services.springdatajpa;

import com.oskarro.doortodoor.model.Owner;
import com.oskarro.doortodoor.repositories.OwnerRepository;
import com.oskarro.doortodoor.repositories.ProductRepository;
import com.oskarro.doortodoor.repositories.ProductTypeRepository;
import com.oskarro.doortodoor.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, ProductRepository productRepository,
                             ProductTypeRepository productTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {

        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);

    }
}
