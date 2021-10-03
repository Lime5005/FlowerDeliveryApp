package com.lime.flowerdeliver.service;

import com.lime.flowerdeliver.controller.dto.RecipientAndPrice;
import com.lime.flowerdeliver.entity.Delivery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeliveryService {
    void persist(Delivery delivery);
    Delivery find(Long id);
    Delivery merge(Delivery delivery);
    void delete(Long id);
    Long save(Delivery delivery);
    List<Delivery> findDeliveryByName(String name);
    RecipientAndPrice getBill(Long id);
}
