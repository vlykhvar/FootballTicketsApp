package com.dev.theater.mapper;

import com.dev.theater.model.CinemaHall;
import com.dev.theater.model.Movie;
import com.dev.theater.model.MovieSession;
import com.dev.theater.model.dto.MovieSessionRequestDto;
import com.dev.theater.model.dto.MovieSessionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
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
        movieSession.setMovie(new Movie());
        movieSession.setCinemaHall(new CinemaHall());
        movieSession.getMovie().setTitle(movieSessionRequestDto.getMovieTitle());
        movieSession.getCinemaHall()
                .setDescription(movieSessionRequestDto.getCinemaHallDescription());
        return movieSession;
    }
}
