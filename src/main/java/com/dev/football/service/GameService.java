package com.dev.football.service;

import com.dev.football.model.Game;
import java.util.List;

public interface GameService {
    Game add(Game game);

    List<Game> getAll();

    Game findById(Long gameId);
}
