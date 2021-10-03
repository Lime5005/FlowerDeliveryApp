package com.lime.flowerdeliver.controller.dto;

import java.math.BigDecimal;

public class RecipientAndPrice {
    private String name;
    private BigDecimal price;

    public RecipientAndPrice() {
    }

    public RecipientAndPrice(String recipientName, BigDecimal price) {
        this.name = recipientName;
        this.price = price;
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
}
