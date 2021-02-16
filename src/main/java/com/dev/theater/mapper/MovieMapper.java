package com.dev.theater.mapper;

import com.dev.theater.model.Movie;
import com.dev.theater.model.dto.MovieRequestDto;
import com.dev.theater.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieResponseDto movieToDto(Movie movie) {
        MovieResponseDto movieDto = new MovieResponseDto();
        movieDto.setDescription(movie.getDescription());
        movieDto.setTitle(movie.getTitle());
        movieDto.setId(movie.getId());
        return movieDto;
    }

    public Movie dtoToMovie(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setDescription(movieRequestDto.getDescription());
        movie.setTitle(movieRequestDto.getTitle());
        return movie;
    }
}
