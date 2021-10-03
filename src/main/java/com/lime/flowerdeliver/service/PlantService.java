package com.lime.flowerdeliver.service;

import com.lime.flowerdeliver.dao.PlantRepository;
import com.lime.flowerdeliver.entity.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PlantService {

    @Autowired
    PlantRepository plantRepository;

    public Long save(Plant plant) {
        return plantRepository.save(plant).getId();
    }

//    public Plant getPlantByName(String name){
//        Plant plant = new Plant();
//        plant.setName(name);
//        return plant;
//    }

    public Boolean delivered(Long id) {
        return plantRepository.deliveryCompletedBoolean(id);
    }

    public List<Plant> findPlantsBelowPrice(BigDecimal price) {
        return plantRepository.findByPriceLessThan(price);
    }

    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    public Optional<Plant> findById(Long id) {
        return plantRepository.findById(id);
    }
}
