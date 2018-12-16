package com.oskarro.doortodoor.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    // set up builder pattern
    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city,
                 String telephone, Set<Product> products) {
        super(id, firstName, lastName); // inherit all parameters from parent class (Person)
        this.address = address;
        this.city = city;
        this.telephone = telephone;

        // if builder pattern doesn't pass in something, that's not going to get overridden
        if (products != null) {
            this.products = products;
        }
    }


    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Product> products = new HashSet<>();


    // return the product with the given name, or null if none found for this Owner
    public Product getProduct(String name) {
        return getProduct(name, false);
    }

    // return the product with the given name, or null if none found for this Owner
    public Product getProduct(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Product product : products) {
            if (!ignoreNew || !product.isNew()) {
                String compName = product.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return product;
                }
            }
        }
        return null;
    }

}
