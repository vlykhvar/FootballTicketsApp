package com.dev.football.controller;

import com.dev.football.mapper.GameSessionMapper;
import com.dev.football.model.GameSession;
import com.dev.football.model.dto.GameSessionRequestDto;
import com.dev.football.model.dto.GameSessionResponseDto;
import com.dev.football.service.GameSessionService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final GameSessionMapper gameSessionMapper;
    private final GameSessionService gameSessionService;

    @Autowired
    public MovieSessionController(GameSessionMapper gameSessionMapper,
                                  GameSessionService gameSessionService) {
        this.gameSessionMapper = gameSessionMapper;
        this.gameSessionService = gameSessionService;
    }

    @PostMapping
    public void addMovieSession(@RequestBody @Valid GameSessionRequestDto gameSessionRequestDto) {
        GameSession gameSession = gameSessionMapper.dtoToGameSession(gameSessionRequestDto);
        gameSessionService.add(gameSession);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody @Valid GameSessionRequestDto gameSessionRequestDto) {
        GameSession gameSession = gameSessionMapper.dtoToGameSession(gameSessionRequestDto);
        gameSession.setId(id);
        gameSessionService.update(gameSession);
    }

    @GetMapping("/available")
    public List<GameSessionResponseDto> getAvailable(@RequestParam Long movieId,
                                                     @RequestParam
                                              @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                      LocalDate date) {
        return gameSessionService.findAvailableSessions(movieId, date).stream()
                .map(gameSessionMapper::gameSessionToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gameSessionService.delete(id);
    }
}
