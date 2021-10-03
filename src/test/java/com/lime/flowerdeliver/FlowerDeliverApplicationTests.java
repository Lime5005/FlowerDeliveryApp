package com.lime.flowerdeliver;

import com.lime.flowerdeliver.dao.DeliveryRepository;
import com.lime.flowerdeliver.dao.PlantRepository;
import com.lime.flowerdeliver.entity.Delivery;
import com.lime.flowerdeliver.entity.Plant;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FlowerDeliverApplicationTests {

    @Autowired
    javax.persistence.EntityManager entityManager;

    @Autowired
    PlantRepository plantRepository;

    @Autowired
    DeliveryRepository deliveryRepository;

    @Test
    public void testPriceLessThan() {
        //test boundary conditions
        Plant p = plantRepository.save(new Plant("Rose", BigDecimal.valueOf(4.99)));
        plantRepository.save(new Plant("Lily",BigDecimal.valueOf(5.01)));

        List<Plant> cheapPlants = plantRepository.findByPriceLessThan(BigDecimal.valueOf(5));
        System.out.println(cheapPlants);
        Assertions.assertEquals(1, cheapPlants.size(), "Size");
        Assertions.assertEquals(p.getId(), cheapPlants.get(0).getId(), "Id");
    }

    @Test
    void contextLoads() {
    }

}
