package com.lime.flowerdeliver.dao;

import com.lime.flowerdeliver.entity.CandyData;

import java.util.List;

public interface CandyDao {

    List<CandyData> list();
    void addToDelivery(Long candyId, Long deliveryid);
    List<CandyData> findByDelivery(Long deliveryId);
}
