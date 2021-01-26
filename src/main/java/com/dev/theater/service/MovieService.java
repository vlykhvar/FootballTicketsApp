package com.dev.theater.service;

import java.util.List;
import com.dev.theater.model.Movie;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();
}
