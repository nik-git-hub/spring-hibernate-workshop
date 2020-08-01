package org.shop.utils;

import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDetailDto;
import org.shop.dto.OrderDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Convector {

    public static OrderDto toOrderDto(OrderEntity orderEntity) {
        List<OrderDetailDto> orderDetailDtos = orderEntity.getOrderDetailEntities() == null
                ? null : orderEntity.getOrderDetailEntities().stream()
                .map(p -> new OrderDetailDto(p.getId(), p.getName(), p.getPrice()))
                .collect(toList());
        return new OrderDto(orderEntity.getId(), orderEntity.getName(), orderDetailDtos);
    }

    public static OrderEntity toOrderEntity(OrderDto orderDto){
        List<OrderDetailEntity> orderDetailEntities = orderDto.getOrderDetails() == null
                ? null : orderDto.getOrderDetails().stream()
                .map(p -> new OrderDetailEntity(p.getName(), p.getPrice()))
                .collect(toList());
        return new OrderEntity(orderDto.getName(),"", orderDetailEntities);

    }

}
