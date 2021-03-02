package com.dev.football.mapper;

import com.dev.football.model.Game;
import com.dev.football.model.dto.GameRequestDto;
import com.dev.football.model.dto.GameResponseDto;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {
    public GameResponseDto gameToDto(Game game) {
        GameResponseDto gameDto = new GameResponseDto();
        gameDto.setDescription(game.getDescription());
        gameDto.setTitle(game.getTitle());
        gameDto.setId(game.getId());
        return gameDto;
    }

    public Game dtoToGame(GameRequestDto gameRequestDto) {
        Game game = new Game();
        game.setDescription(gameRequestDto.getDescription());
        game.setTitle(gameRequestDto.getTitle());
        return game;
    }
}
