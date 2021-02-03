package com.dev.theater.dao;

import com.dev.theater.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionDao extends Dao<MovieSession> {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);
}
