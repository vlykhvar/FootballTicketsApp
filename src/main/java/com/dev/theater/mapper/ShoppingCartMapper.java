package com.dev.theater.mapper;

import com.dev.theater.model.ShoppingCart;
import com.dev.theater.model.Ticket;
import com.dev.theater.model.dto.ShoppingCartResponseDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    public ShoppingCartResponseDto shoppingCartToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setId(shoppingCart.getId());
        shoppingCartResponseDto.setUserEmail(shoppingCart.getUser().getEmail());
        List<Ticket> listOld = shoppingCart.getTicketList();
        List<Ticket> responseList = new ArrayList<>();
        for (Ticket ticket : listOld) {
            Ticket response = new Ticket();
            response.setId(ticket.getId());
            responseList.add(response);
        }
        shoppingCartResponseDto.setTickets(responseList);
        return shoppingCartResponseDto;
    }
}
