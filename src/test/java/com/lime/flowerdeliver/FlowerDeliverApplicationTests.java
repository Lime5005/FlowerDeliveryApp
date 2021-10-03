package com.lime.flowerdeliver;

import com.lime.flowerdeliver.dao.PlantRepository;
import com.lime.flowerdeliver.entity.Delivery;
import com.lime.flowerdeliver.entity.Plant;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

//@SpringBootTest //Should not use this default annotation if @DataJpaTest is present.
@DataJpaTest
class FlowerDeliverApplicationTests {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    PlantRepository plantRepository;

    // All tests passed.
    @Test
    public void testPriceLessThan() {

        Plant p = this.testEntityManager.persist(new Plant("Rose", BigDecimal.valueOf(4.99)));
        this.testEntityManager.persist(new Plant("Lily",BigDecimal.valueOf(5.01)));

        List<Plant> cheapPlants = this.plantRepository.findByPriceLessThan(BigDecimal.valueOf(5));
        System.out.println(cheapPlants);
        Assertions.assertEquals(1, cheapPlants.size(), "Size");
        Assertions.assertEquals(p.getId(), cheapPlants.get(0).getId(), "Id");
    }

    @Test
    public void testDeliveryCompleted() {
        Plant p = testEntityManager.persist(new Plant("Baz Root", BigDecimal.valueOf(9.99)));
        Delivery d = testEntityManager.persist(new Delivery("Leonard Bernstein", "234 West Side", LocalDateTime.now()));
        d.setPlants(Lists.newArrayList(p));
        p.setDelivery(d);

        Assertions.assertFalse(plantRepository.deliveryCompleted(p.getId()));
        d.setCompleted(true);
        Assertions.assertTrue(plantRepository.deliveryCompleted(p.getId()));
    }

    @Test
    void contextLoads() {
    }

}
