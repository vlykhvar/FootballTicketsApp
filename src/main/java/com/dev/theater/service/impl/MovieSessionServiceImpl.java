package com.dev.theater.service.impl;

import com.dev.theater.dao.MovieSessionDao;
import com.dev.theater.library.Inject;
import com.dev.theater.library.Service;
import com.dev.theater.model.MovieSession;
import com.dev.theater.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    @Inject
    private MovieSessionDao movieSessionDao;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionDao.add(session);
    }
}
