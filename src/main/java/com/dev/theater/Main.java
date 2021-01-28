package com.dev.theater;

import com.dev.theater.library.Injector;
import com.dev.theater.model.Movie;
import com.dev.theater.service.MovieService;

public class Main {
    private static Injector injector = Injector.getInstance(Main.class.getPackageName());

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(movie);

        movieService.getAll().forEach(System.out::println);
    }
}
