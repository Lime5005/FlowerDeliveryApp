package com.lime.flowerdeliver.entity;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Flower extends Plant {

//    @Column(name = "color") // No need?
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
