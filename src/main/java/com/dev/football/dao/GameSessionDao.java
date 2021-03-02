package com.dev.football.dao;

import com.dev.football.model.GameSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GameSessionDao extends GenericDao<GameSession> {
    List<GameSession> findAvailableSessions(Long gameId, LocalDate date);

    GameSession update(GameSession gameSession);

    boolean delete(Long id);

    Optional<GameSession> getById(Long id);
}
