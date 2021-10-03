package com.lime.flowerdeliver.dao;

import com.lime.flowerdeliver.controller.dto.RecipientAndPrice;
import com.lime.flowerdeliver.entity.Delivery;
import com.lime.flowerdeliver.entity.Plant;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class DeliveryRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    public Delivery find(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    public Delivery merge(Delivery delivery) {
        return entityManager.merge(delivery);
    }

    public void delete(Long id) {
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }

    //1, named query:
//    private static final String FIND_DELIVERY_BY_NAME = "select d from Delivery d where d.recipientName = :recipientName ";

    //2, @NamedQuery annotation should be defined in the Entity class, not here.

    public List<Delivery> findDeliveryByName(String name) {
        //Solution 1, createQuery
       // TypedQuery<Delivery> query = entityManager.createQuery("FIND_DELIVERY_BY_NAME", Delivery.class);

        //Solution 2, createNamedQuery
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.findByName", Delivery.class);
        query.setParameter("recipientName", name);

        return query.getResultList();
    }

    //Solution 1: createQuery:
    //Very important: MUST add @JsonManagedReference and @JsonBackReference to Delivery and Plant.
    private static final String GET_PRICE_BY_ID = "select new com.lime.flowerdeliver.controller.dto.RecipientAndPrice(d.recipientName, SUM(p.price)) " +
            "from Delivery d inner join Plant p on d.id = p.delivery.id where d.id = :id";

    public RecipientAndPrice getBill(Long deliveryId) {
        TypedQuery<RecipientAndPrice> query = entityManager.createQuery(GET_PRICE_BY_ID, RecipientAndPrice.class);
        query.setParameter("id", deliveryId);

        return query.getSingleResult();
    }

    //Solution 2: CriteriaBuilder
//    public RecipientAndPrice getBill(Long deliveryId){
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<RecipientAndPrice> query = cb.createQuery(RecipientAndPrice.class);
//        Root<Plant> root = query.from(Plant.class);
//        query.select(
//                        cb.construct(
//                                RecipientAndPrice.class,
//                                root.get("delivery").get("recipientName"),
//                                cb.sum(root.get("price"))))
//                .where(cb.equal(root.get("delivery").get("id"), deliveryId));
//        return entityManager.createQuery(query).getSingleResult();
//    }

}
