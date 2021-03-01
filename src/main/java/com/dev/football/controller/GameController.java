package com.dev.football.controller;

import com.dev.football.mapper.GameMapper;
import com.dev.football.model.dto.GameRequestDto;
import com.dev.football.model.dto.GameResponseDto;
import com.dev.football.service.GameService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameMapper gameMapper;
    private final GameService gameService;

    @Autowired
    public GameController(GameMapper gameMapper, GameService gameService) {
        this.gameMapper = gameMapper;
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameResponseDto> getGames() {
        return gameService.getAll().stream()
                .map(gameMapper::gameToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void addGame(@RequestBody @Valid GameRequestDto gameRequestDto) {
        gameService.add(gameMapper.dtoToGame(gameRequestDto));
    }
}
