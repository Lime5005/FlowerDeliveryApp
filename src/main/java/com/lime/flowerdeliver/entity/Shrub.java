package com.lime.flowerdeliver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Shrub extends Plant {

//    @Column(name="height")
    private int heightCm;

//    @Column(name="width")
    private int widthCm;

    public int getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(int heightCm) {
        this.heightCm = heightCm;
    }

    public int getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(int widthCm) {
        this.widthCm = widthCm;
    }
}
