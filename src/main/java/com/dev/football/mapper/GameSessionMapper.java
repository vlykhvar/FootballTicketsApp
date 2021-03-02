package com.dev.football.mapper;

import com.dev.football.model.GameSession;
import com.dev.football.model.dto.GameSessionRequestDto;
import com.dev.football.model.dto.GameSessionResponseDto;
import com.dev.football.service.GameService;
import com.dev.football.service.StadiumService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameSessionMapper {
    private final GameService gameService;
    private final StadiumService stadiumService;

    @Autowired
    public GameSessionMapper(GameService gameService, StadiumService stadiumService) {
        this.gameService = gameService;
        this.stadiumService = stadiumService;
    }

    public GameSessionResponseDto gameSessionToDto(GameSession gameSession) {
        GameSessionResponseDto gameSessionDto = new GameSessionResponseDto();
        gameSessionDto.setId(gameSession.getId());
        gameSessionDto.setShowTime(gameSession.getShowTime().toString());
        gameSessionDto.setGameTitle(gameSession.getGame().getTitle());
        gameSessionDto.setStadiumId(gameSession.getStadium().getId());
        gameSessionDto.setStadiumDescription(gameSession.getStadium().getDescription());
        return gameSessionDto;
    }

    public GameSession dtoToGameSession(GameSessionRequestDto gameSessionRequestDto) {
        GameSession gameSession = new GameSession();
        gameSession.setGame(gameService.findById(gameSessionRequestDto.getGameId()));
        gameSession.setStadium(
                stadiumService.findById(gameSessionRequestDto.getStadiumId()));
        gameSession.setShowTime(LocalDateTime.parse(gameSessionRequestDto.getShowTime()));
        return gameSession;
    }
}
