package com.oskarro.doortodoor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "couriers")
public class Courier extends Person {

    // JPA is going to try load everything all at once
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "courier_specialities",
            joinColumns = @JoinColumn(name = "courier_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "company")
    private String company;

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
