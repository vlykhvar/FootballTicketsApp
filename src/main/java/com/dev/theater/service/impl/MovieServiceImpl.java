package com.dev.theater.service.impl;

import com.dev.theater.dao.MovieDao;
import com.dev.theater.library.Inject;
import com.dev.theater.library.Service;
import com.dev.theater.model.Movie;
import com.dev.theater.service.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
