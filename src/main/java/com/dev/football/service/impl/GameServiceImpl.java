package com.dev.football.service.impl;

import com.dev.football.dao.GameDao;
import com.dev.football.model.Game;
import com.dev.football.service.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    private final GameDao gameDao;

    @Autowired
    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    public Game add(Game game) {
        return gameDao.add(game);
    }

    @Override
    public List<Game> getAll() {
        return gameDao.getAll();
    }

    @Override
    public Game findById(Long gameId) {
        return gameDao.findById(gameId);
    }
}
