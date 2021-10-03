package com.lime.flowerdeliver.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.lime.flowerdeliver.ClientViews;
import com.lime.flowerdeliver.controller.dto.RecipientAndPrice;
import com.lime.flowerdeliver.entity.Delivery;
import com.lime.flowerdeliver.service.DeliveryService;
import com.lime.flowerdeliver.service.DeliveryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @PostMapping("/delivery")
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
         return deliveryService.save(delivery);
    }

    @GetMapping(value = "/{name}")
    public List<Delivery> findDeliveryByName (@PathVariable String name) {
        return deliveryService.findDeliveryByName(name);
    }

    @GetMapping("/bill/{id}")
    public RecipientAndPrice getBill(@PathVariable Long id) {
        return deliveryService.getBill(id);
    }

}
