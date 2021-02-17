package com.dev.theater.mapper;

import com.dev.theater.model.Order;
import com.dev.theater.model.dto.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponseDto orderToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderTime(order.getOrderTime().toString());
        orderResponseDto.setTickets(order.getTickets());
        orderResponseDto.setUserEmail(order.getUser().getEmail());
        return orderResponseDto;
    }
}
