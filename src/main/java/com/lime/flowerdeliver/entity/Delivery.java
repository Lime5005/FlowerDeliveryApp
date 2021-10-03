package com.lime.flowerdeliver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@NamedQuery(
        name = "Delivery.findByName",
        query = "select d from Delivery d where d.recipientName = :recipientName")
@Entity
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Nationalized
    private String recipientName;

    @Column(name = "address_full", length = 500)
    private String address;

    @Type(type = "yes_no")
    private Boolean completed = false;

    @Column(name = "date_time")
    private LocalDateTime deliveryTime;

    public Delivery(String recipientName, String address, LocalDateTime deliveryTime) {
        this.recipientName = recipientName;
        this.address = address;
        this.deliveryTime = deliveryTime;
    }

    public Delivery() {
    }

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Plant> plants;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

}
