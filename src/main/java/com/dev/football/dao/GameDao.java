package com.dev.football.dao;

import com.dev.football.model.Game;
import java.util.List;

public interface GameDao extends GenericDao<Game> {
    List<Game> getAll();

    Game findById(Long gameId);
}
