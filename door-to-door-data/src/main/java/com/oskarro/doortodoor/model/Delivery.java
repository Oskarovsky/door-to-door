package com.oskarro.doortodoor.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "deliveries")
public class Delivery extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private String cost;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
