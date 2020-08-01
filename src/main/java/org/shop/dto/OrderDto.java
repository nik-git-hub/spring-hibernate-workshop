package org.shop.dto;

import java.util.List;

/**
 * feel free to add any code to this class
 */
public class OrderDto {
    private Long id;
    private String name;
    private List<OrderDetailDto> orderDetails;

    public OrderDto(long id, String name, List<OrderDetailDto> orderDetails) {
        this.id = id;
        this.name = name;
        this.orderDetails = orderDetails;
    }

    public OrderDto(String name, List<OrderDetailDto> orderDetails) {
        this.name = name;
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "\nOrderDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }

    public List<OrderDetailDto> getOrderDetails() {
        return orderDetails;
    }

    public String getName() {
        return name;
    }
}
