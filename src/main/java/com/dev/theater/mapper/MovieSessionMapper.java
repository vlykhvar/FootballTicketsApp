package com.dev.theater.mapper;

import com.dev.theater.model.MovieSession;
import com.dev.theater.model.dto.MovieSessionRequestDto;
import com.dev.theater.model.dto.MovieSessionResponseDto;
import com.dev.theater.service.CinemaHallService;
import com.dev.theater.service.MovieService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public MovieSessionMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponseDto movieSessionToDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionDto = new MovieSessionResponseDto();
        movieSessionDto.setId(movieSession.getId());
        movieSessionDto.setShowTime(movieSession.getShowTime().toString());
        movieSessionDto.setMovieTitle(movieSession.getMovie().getTitle());
        movieSessionDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionDto.setCinemaHallDescription(movieSession.getCinemaHall().getDescription());
        return movieSessionDto;
    }

    public MovieSession dtoToMovieSession(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.findById(movieSessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(
                cinemaHallService.findById(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setShowTime(LocalDateTime.parse(movieSessionRequestDto.getShowTime()));
        return movieSession;
    }
}
