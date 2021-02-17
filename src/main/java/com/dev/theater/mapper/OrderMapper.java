package com.dev.theater.mapper;

import com.dev.theater.model.Order;
import com.dev.theater.model.Ticket;
import com.dev.theater.model.dto.OrderResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponseDto orderToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderTime(order.getOrderTime().toString());
        List<Long> responseList = order.getTickets()
                .stream().map(Ticket::getId).collect(Collectors.toList());
        orderResponseDto.setTicketIds(responseList);
        orderResponseDto.setUserEmail(order.getUser().getEmail());
        return orderResponseDto;
    }
}
