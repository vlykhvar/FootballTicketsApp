package com.dev.theater;

import com.dev.theater.library.Injector;
import com.dev.theater.model.CinemaHall;
import com.dev.theater.model.Movie;
import com.dev.theater.model.MovieSession;
import com.dev.theater.service.CinemaHallService;
import com.dev.theater.service.MovieService;
import com.dev.theater.service.MovieSessionService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static Injector injector
            = Injector.getInstance(Main.class.getPackageName());
    private static MovieService movieService
            = (MovieService) injector.getInstance(MovieService.class);
    private static CinemaHallService cinemaHallService
            = (CinemaHallService) injector.getInstance(CinemaHallService.class);
    private static MovieSessionService movieSessionService
            = (MovieSessionService) injector.getInstance(MovieSessionService.class);

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        movieService.add(movie);
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription("blue");
        cinemaHall.setCapacity(130);
        cinemaHallService.add(cinemaHall);
        movieService.getAll().forEach(System.out::println);
        cinemaHallService.getAll().forEach(System.out::println);
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(LocalDateTime.now());
        movieSessionService.add(movieSession);
        movieSessionService.findAvailableSessions(movie.getId(),
                LocalDate.now()).forEach(System.out::println);
    }
}
