package com.lime.flowerdeliver.service;

import com.lime.flowerdeliver.controller.dto.RecipientAndPrice;
import com.lime.flowerdeliver.dao.DeliveryRepository;
import com.lime.flowerdeliver.entity.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public void persist(Delivery delivery) {
       deliveryRepository.persist(delivery);
    }

    @Override
    public Delivery find(Long id) {
        return deliveryRepository.find(id);
    }

    @Override
    public Delivery merge(Delivery delivery) {
        return deliveryRepository.merge(delivery);
    }

    @Override
    public void delete(Long id) {
        deliveryRepository.delete(id);
    }

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    @Override
    public List<Delivery> findDeliveryByName (String name) {
        return deliveryRepository.findDeliveryByName(name);
    }

    public RecipientAndPrice getBill(Long id) {
        return deliveryRepository.getBill(id);
    }
}
