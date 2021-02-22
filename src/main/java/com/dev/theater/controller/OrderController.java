package com.dev.theater.controller;

import com.dev.theater.mapper.OrderMapper;
import com.dev.theater.model.User;
import com.dev.theater.model.dto.OrderResponseDto;
import com.dev.theater.service.OrderService;
import com.dev.theater.service.ShoppingCartService;
import com.dev.theater.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final OrderMapper orderMapper;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public OrderController(OrderService orderService,
                           UserService userService,
                           OrderMapper orderMapper,
                           ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.userService = userService;
        this.orderMapper = orderMapper;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public List<OrderResponseDto> getAllOrderByUserId(Authentication authentication) {
        String nameUser = authentication.getName();
        User user = userService.findByEmail(nameUser).orElseThrow();
        return orderService.getOrdersHistory(user)
                .stream().map(orderMapper::orderToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public void completeOrder(Authentication authentication) {
        orderService.completeOrder(shoppingCartService
                .getByUser(userService
                        .findByEmail(authentication.getName()).orElseThrow()));
    }
}
