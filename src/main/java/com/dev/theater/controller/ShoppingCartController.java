package com.dev.theater.controller;

import com.dev.theater.mapper.ShoppingCartMapper;
import com.dev.theater.model.dto.ShoppingCartResponseDto;
import com.dev.theater.service.MovieSessionService;
import com.dev.theater.service.ShoppingCartService;
import com.dev.theater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartMapper shoppingCartMapper;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final MovieSessionService movieSessionService;

    @Autowired
    public ShoppingCartController(ShoppingCartMapper shoppingCartMapper,
                                  ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService,
                                  UserService userService) {
        this.shoppingCartMapper = shoppingCartMapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return shoppingCartMapper.shoppingCartToDto(shoppingCartService
                .getByUser(userService.findById(userId).orElseThrow()));
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long userId,@RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService
                .getById(movieSessionId).orElseThrow(),
                userService.findById(userId).orElseThrow());
    }
}
