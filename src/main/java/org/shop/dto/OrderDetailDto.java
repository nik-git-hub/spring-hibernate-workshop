package org.shop.dto;

import java.math.BigDecimal;

/**
 * feel free to add any code to this class
 */
public class OrderDetailDto {
    private Long id;
    private String name;
    private BigDecimal price;

    public OrderDetailDto(long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public OrderDetailDto(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetailDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
