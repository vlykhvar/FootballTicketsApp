package com.dev.theater.mapper;

import com.dev.theater.model.ShoppingCart;
import com.dev.theater.model.dto.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    public ShoppingCartResponseDto shoppingCartToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setId(shoppingCart.getId());
        shoppingCartResponseDto.setTickets(shoppingCart.getTicketList());
        shoppingCartResponseDto.setUserEmail(shoppingCart.getUser().getEmail());
        return shoppingCartResponseDto;
    }
}
