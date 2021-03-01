package com.dev.football.service;

import com.dev.football.model.GameSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GameSessionService {
    List<GameSession> findAvailableSessions(Long gameId, LocalDate date);

    GameSession add(GameSession session);

    void update(GameSession gameSession);

    boolean delete(Long id);

    Optional<GameSession> getById(Long id);
}
