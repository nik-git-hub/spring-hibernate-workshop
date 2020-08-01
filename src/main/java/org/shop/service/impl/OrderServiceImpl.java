package org.shop.service.impl;

import org.shop.db.OrdersRepository;
import org.shop.dto.OrderDto;
import org.shop.service.OrdersService;
import org.shop.utils.Convector;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    public OrderServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<OrderDto> findAll() {
        return ordersRepository.findAll().stream().map(Convector::toOrderDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto findOrderBy(long id) {
        return Convector.toOrderDto(ordersRepository.findOrderBy(id));
    }

    @Override
    public void saveOrder(OrderDto orderDto) {
        ordersRepository.saveOrder(Convector.toOrderEntity(orderDto));
    }

    @Override
    public void deleteOrder(long orderId) {
        ordersRepository.deleteOrder(orderId);
    }

    @Override
    public OrderDto update(long orderId, String name){
        return Convector.toOrderDto(ordersRepository.update(orderId, name));
    }

}
