package org.shop.db;

import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDto;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface OrdersRepository {

    List<OrderEntity> findAll();
    OrderEntity update(long orderId, String name);
    OrderEntity findOrderBy(long orderId);
    void deleteOrder(long orderId);
    void saveOrder(OrderEntity orderEntity);

}
