package com.oskarro.doortodoor.model;

import java.util.HashSet;
import java.util.Set;

public class Courier extends Person {

    private Set<Speciality> specialities = new HashSet<>();
    private String equipment;
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
