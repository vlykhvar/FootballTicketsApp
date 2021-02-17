package com.dev.theater.service;

import com.dev.theater.model.MovieSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieSessionService {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession session);

    void update(MovieSession movieSession);

    boolean delete(Long id);

    Optional<MovieSession> getById(Long id);
}
