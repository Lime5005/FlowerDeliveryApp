package com.lime.flowerdeliver.dao;

import com.lime.flowerdeliver.entity.CandyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CandyDAOImpl implements CandyDao {

    @Autowired
    NamedParameterJdbcTemplate template;

    //we can avoid some typo-based errors by using string constants
    private static final String CANDY_ID = "candyId";
    private static final String DELIVERY_ID = "deliveryId";

    private static final String SELECT_ALL = "select * from candy";

    private static final String INSERT_DELIVERY = "insert into candy_delivery (candy_id, delivery_id) values (:" + CANDY_ID + ", :" + DELIVERY_ID + ")";

    private static final String FIND_CANDY_BY_DELIVERY = "select c.* from candy_delivery " +
            "AS cd join candy AS c on c.id = cd.candy_id where cd.delivery_id = :" + DELIVERY_ID;

    private static final RowMapper<CandyData> candyDataRowMapper =
            new BeanPropertyRowMapper<>(CandyData.class);

    @Override
    public List<CandyData> list() {
        return template.query(SELECT_ALL, candyDataRowMapper);
    }

    @Override
    public void addToDelivery(Long candyId, Long deliveryId) {
        template.update(INSERT_DELIVERY, new MapSqlParameterSource().addValue(CANDY_ID, candyId).addValue(DELIVERY_ID, deliveryId));
    }

    @Override
    public List<CandyData> findByDelivery(Long deliveryId) {
        return template.query(FIND_CANDY_BY_DELIVERY, new MapSqlParameterSource(DELIVERY_ID, deliveryId), candyDataRowMapper);
    }
}
