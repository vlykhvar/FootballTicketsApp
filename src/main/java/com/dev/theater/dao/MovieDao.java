package com.dev.theater.dao;

import com.dev.theater.library.Dao;
import com.dev.theater.model.Movie;
import java.util.List;

@Dao
public interface MovieDao {
    Movie add(Movie movie);

    List<Movie> getAll();
}
