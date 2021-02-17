package com.dev.theater.dao;

import com.dev.theater.model.MovieSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieSessionDao extends GenericDao<MovieSession> {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession update(MovieSession movieSession);

    boolean delete(Long id);

    Optional<MovieSession> getById(Long id);
}
