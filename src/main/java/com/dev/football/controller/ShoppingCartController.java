package com.dev.football.controller;

import com.dev.football.mapper.ShoppingCartMapper;
import com.dev.football.model.dto.ShoppingCartResponseDto;
import com.dev.football.service.GameSessionService;
import com.dev.football.service.ShoppingCartService;
import com.dev.football.service.UserService;
import org.apache.maven.artifact.repository.Authentication;
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
    private final GameSessionService gameSessionService;

    @Autowired
    public ShoppingCartController(ShoppingCartMapper shoppingCartMapper,
                                  ShoppingCartService shoppingCartService,
                                  GameSessionService gameSessionService,
                                  UserService userService) {
        this.shoppingCartMapper = shoppingCartMapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.gameSessionService = gameSessionService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return shoppingCartMapper.shoppingCartToDto(shoppingCartService
                .getByUser(userService.findById(userId).orElseThrow()));
    }

    @PostMapping("/game-sessions")
    public void addGameSession(Authentication authentication, @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(gameSessionService
                .getById(movieSessionId).orElseThrow(),
                userService.findByEmail(authentication.getUsername()).orElseThrow());
    }
}
