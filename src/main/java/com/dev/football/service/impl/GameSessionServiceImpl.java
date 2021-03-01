package com.dev.football.service.impl;

import com.dev.football.dao.GameSessionDao;
import com.dev.football.model.GameSession;
import com.dev.football.service.GameSessionService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameSessionServiceImpl implements GameSessionService {
    private final GameSessionDao gameSessionDao;

    @Autowired
    public GameSessionServiceImpl(GameSessionDao gameSessionDao) {
        this.gameSessionDao = gameSessionDao;
    }

    @Override
    public List<GameSession> findAvailableSessions(Long gameId, LocalDate date) {
        return gameSessionDao.findAvailableSessions(gameId, date);
    }

    @Override
    public GameSession add(GameSession session) {
        return gameSessionDao.add(session);
    }

    @Override
    public void update(GameSession gameSession) {
        gameSessionDao.update(gameSession);
    }

    @Override
    public boolean delete(Long id) {
        return gameSessionDao.delete(id);
    }

    @Override
    public Optional<GameSession> getById(Long id) {
        return gameSessionDao.getById(id);
    }
}
