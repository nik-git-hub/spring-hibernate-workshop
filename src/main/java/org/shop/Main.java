package org.shop;

import org.shop.dto.OrderDetailDto;
import org.shop.dto.OrderDto;
import org.shop.service.OrdersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-context.xml");
        OrdersService ordersService = context.getBean("orderServiceImpl",OrdersService.class);

        List<OrderDto> orderEntities = ordersService.findAll();
        System.out.println(orderEntities);

       OrderDto orderEntities2 = ordersService.findOrderBy(2);
       System.out.println(orderEntities2);

//      ordersService.deleteOrder(6);
 //      ordersService.update(2, "order 2");

        
//    List<OrderDetailDto> orderDtos = Arrays.asList(new OrderDetailDto("order 881", BigDecimal.valueOf(88.56)),
//            new OrderDetailDto("order 882", BigDecimal.valueOf(88.66)));
//    OrderDto orderDto = new OrderDto("order 88", orderDtos);
//    ordersService.saveOrder(orderDto);
    }

}
