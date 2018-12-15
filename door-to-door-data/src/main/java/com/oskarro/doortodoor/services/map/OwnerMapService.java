package com.oskarro.doortodoor.services.map;

import com.oskarro.doortodoor.model.Owner;
import com.oskarro.doortodoor.model.Product;
import com.oskarro.doortodoor.services.OwnerService;
import com.oskarro.doortodoor.services.ProductService;
import com.oskarro.doortodoor.services.ProductTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final ProductTypeService productTypeService;
    private final ProductService productService;

    public OwnerMapService(ProductTypeService productTypeService, ProductService productService) {
        this.productTypeService = productTypeService;
        this.productService = productService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {
            if (object.getProducts() != null) {
                object.getProducts().forEach(product -> {
                    if (product.getProductType() != null) {
                        if(product.getProductType().getId() == null) {
                            product.setProductType((productTypeService.save(product.getProductType())));
                        }
                    } else {
                        throw new RuntimeException("Product Type is required");
                    }

                    if(product.getId() == null) {
                        Product savedProduct = productService.save(product);
                        product.setId(savedProduct.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {

        //todo - implementation
        return null;
    }
}