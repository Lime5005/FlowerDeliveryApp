package com.lime.flowerdeliver.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.lime.flowerdeliver.ClientViews;
import com.lime.flowerdeliver.entity.Plant;
import com.lime.flowerdeliver.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.SecondaryTable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class PlantController {

    @Autowired
    private PlantService plantService;

//    public PlantDto getPlantDto(String name) {
//        Plant plant = plantService.getPlantByName(name);
//        return convertPlantToPlantDto(plant);
//    }
//
//    private PlantDto convertPlantToPlantDto(Plant plant) {
//        PlantDto dto = new PlantDto();
//        BeanUtils.copyProperties(plant, dto);//(from, to)
//        return dto;
//    }

//    @JsonView(ClientViews.Public.class)
//    public Plant getFilteredPlant(String name){
//        return plantService.getPlantByName(name);
//    }

    @PostMapping("/plant")
    public Long save(@RequestBody Plant plant) {
        return plantService.save(plant);
    }

    @GetMapping("/plant/under-price/{price}")
    public List<Plant> plantsCheaperThan(@PathVariable BigDecimal price) {
        return plantService.findPlantsBelowPrice(price);
    }

    @GetMapping("/plant")
    public List<Plant> getAll() {
        return plantService.getAllPlants();
    }

    @GetMapping("/plant/delivered/{id}")
    public Boolean delivered(@PathVariable Long id) {
        return plantService.delivered(id);
    }

    @GetMapping("/plant/{id}")
    public Optional<Plant> findById(Long id) {
        return plantService.findById(id);
    }
}
