package com.dev.theater.mapper;

import com.dev.theater.model.CinemaHall;
import com.dev.theater.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto cinemaHallToDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallDto = new CinemaHallResponseDto();
        cinemaHallDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallDto.setId(cinemaHall.getId());
        cinemaHallDto.setDescription(cinemaHall.getDescription());
        return cinemaHallDto;
    }

    public CinemaHall dtoToCinemaHall(CinemaHallResponseDto cinemaHallDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallDto.getCapacity());
        cinemaHall.setDescription(cinemaHallDto.getDescription());
        return cinemaHall;
    }
}
