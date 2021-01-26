package com.dev.theater.dao;

import java.util.List;

import com.dev.theater.library.Dao;
import com.dev.theater.model.Movie;

@Dao
public interface MovieDao {
    Movie add(Movie movie);

    List<Movie> getAll();
}
