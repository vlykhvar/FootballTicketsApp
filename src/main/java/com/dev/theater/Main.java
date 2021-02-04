package com.dev.theater;

import com.dev.theater.exception.AuthenticationException;
import com.dev.theater.library.Injector;
import com.dev.theater.model.CinemaHall;
import com.dev.theater.model.Movie;
import com.dev.theater.model.MovieSession;
import com.dev.theater.model.ShoppingCart;
import com.dev.theater.model.Ticket;
import com.dev.theater.model.User;
import com.dev.theater.service.CinemaHallService;
import com.dev.theater.service.MovieService;
import com.dev.theater.service.MovieSessionService;
import com.dev.theater.service.OrderService;
import com.dev.theater.service.ShoppingCartService;
import com.dev.theater.service.UserService;
import com.dev.theater.service.security.AuthenticationService;
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
    private static UserService userService
            = (UserService) injector.getInstance(UserService.class);
    private static AuthenticationService authenticationService
            = (AuthenticationService) injector.getInstance(AuthenticationService.class);
    private static ShoppingCartService shoppingCartService
            = (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
    private static OrderService orderService
            = (OrderService) injector.getInstance(OrderService.class);

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
        authenticationService.register("test2@bigmir.net", "12345");
        System.out.println(authenticationService.login("test2@bigmir.net", "12345").toString());
        userService.getAll().forEach(System.out::println);
        shoppingCartService.addSession(movieSession, user);
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setMovieSession(movieSession);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        shoppingCartService.addSession(movieSession, user);
        System.out.println(shoppingCart);
        System.out.println(shoppingCart);
        orderService.completeOrder(shoppingCartService.getByUser(user));
        orderService.getOrdersHistory(user).forEach(System.out::println);
    }
}
