package com.dev.theater.mapper;

import com.dev.theater.model.Order;
import com.dev.theater.model.Ticket;
import com.dev.theater.model.dto.OrderResponseDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponseDto orderToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderTime(order.getOrderTime().toString());
        List<Ticket> listOld = order.getTickets();
        List<Ticket> responseList = new ArrayList<>();
        for (Ticket ticket : listOld) {
            Ticket response = new Ticket();
            response.setId(ticket.getId());
            responseList.add(response);
        }
        orderResponseDto.setTickets(responseList);
        orderResponseDto.setUserEmail(order.getUser().getEmail());
        return orderResponseDto;
    }
}
