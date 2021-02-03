package com.dev.theater.dao;

import com.dev.theater.model.Movie;
import java.util.List;

public interface MovieDao extends GenericDao<Movie> {
    List<Movie> getAll();
}
