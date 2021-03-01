package com.dev.football.mapper;

import com.dev.football.model.Stadium;
import com.dev.football.model.dto.StadiumRequestDto;
import com.dev.football.model.dto.StadiumResponseDto;
import org.springframework.stereotype.Component;

@Component
public class StadiumMapper {
    public StadiumResponseDto cinemaHallToDto(Stadium stadium) {
        StadiumResponseDto stadiumResponseDto = new StadiumResponseDto();
        stadiumResponseDto.setCapacity(stadium.getCapacity());
        stadiumResponseDto.setId(stadium.getId());
        stadiumResponseDto.setDescription(stadium.getDescription());
        return stadiumResponseDto;
    }

    public Stadium dtoToCinemaHall(StadiumRequestDto stadiumRequestDto) {
        Stadium stadium = new Stadium();
        stadium.setCapacity(stadiumRequestDto.getCapacity());
        stadium.setDescription(stadiumRequestDto.getDescription());
        return stadium;
    }
}
