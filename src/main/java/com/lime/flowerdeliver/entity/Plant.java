package com.lime.flowerdeliver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.lime.flowerdeliver.ClientViews;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

//    @JsonView(ClientViews.Public.class)
    @Nationalized //Support international language characters
    @Column(name = "name")
    private String name;

//    @JsonView(ClientViews.Public.class)
    @Column(name = "price", precision=12, scale=4)
    private BigDecimal price;

    public Plant() {
    }

    public Plant(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", delivery=" + delivery +
                '}';
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name="delivery_id")
    private Delivery delivery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
