package com.dev.theater.mapper;

import com.dev.theater.model.ShoppingCart;
import com.dev.theater.model.Ticket;
import com.dev.theater.model.dto.ShoppingCartResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    public ShoppingCartResponseDto shoppingCartToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setId(shoppingCart.getId());
        shoppingCartResponseDto.setUserEmail(shoppingCart.getUser().getEmail());
        List<Long> responseList = shoppingCart.getTicketList()
                .stream().map(Ticket::getId).collect(Collectors.toList());
        shoppingCartResponseDto.setTicketIds(responseList);
        return shoppingCartResponseDto;
    }
}
