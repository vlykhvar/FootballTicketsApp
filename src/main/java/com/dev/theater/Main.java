package com.dev.theater;

import com.dev.theater.library.Injector;
import com.dev.theater.model.CinemaHall;
import com.dev.theater.model.Movie;
import com.dev.theater.model.MovieSession;
import com.dev.theater.model.User;
import com.dev.theater.service.CinemaHallService;
import com.dev.theater.service.MovieService;
import com.dev.theater.service.MovieSessionService;
import com.dev.theater.service.UserService;
import com.dev.theater.service.security.AuthenticationService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.security.sasl.AuthenticationException;

public class Main {
    private static Injector injector
            = Injector.getInstance(Main.class.getPackageName());
    private static MovieService movieService
            = (MovieService) injector.getInstance(MovieService.class);
    private static CinemaHallService cinemaHallService
            = (CinemaHallService) injector.getInstance(CinemaHallService.class);
    private static MovieSessionService movieSessionService
            = (MovieSessionService) injector.getInstance(MovieSessionService.class);
    private static UserService userService
            = (UserService) injector.getInstance(UserService.class);
    private static AuthenticationService authenticationService
            = (AuthenticationService) injector.getInstance(AuthenticationService.class);

    public static void main(String[] args) throws AuthenticationException {
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
        User user = authenticationService.register("test@bigmir.net", "12345");
        System.out.println(user.toString());
        System.out.println(userService.findByEmail("test@bigmir.net").toString());
    }
}
