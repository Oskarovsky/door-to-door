package com.oskarro.doortodoor.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    // set up builder pattern
    @Builder
    public Product(Long id, ProductType productType, Owner owner, String name, String description, String size,
                   String price, String imageUrl, String endLocalization, String startLocalization,
                   Set<Delivery> deliveries) {
        super(id);
        this.productType = productType;
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
        this.imageUrl = imageUrl;
        this.endLocalization = endLocalization;
        this.startLocalization = startLocalization;
        this.deliveries = deliveries;
    }

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    private String price;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "end_localization")
    private String endLocalization;

    @Column(name = "start_localization")
    private String startLocalization;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<Delivery> deliveries = new HashSet<>();
}
