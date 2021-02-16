package com.dev.theater.service;

import com.dev.theater.model.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();

    Movie findById(Long movieId);
}
