package com.oskarro.doortodoor.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "couriers")
public class Courier extends Person {

    // JPA is going to try load everything all at once
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "courier_specialities",
            joinColumns = @JoinColumn(name = "courier_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courier")
    private Set<Delivery> deliveries = new HashSet<>();

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "company")
    private String company;

}
