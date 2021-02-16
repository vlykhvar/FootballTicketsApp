package com.dev.theater.controller;

import com.dev.theater.mapper.CinemaHallMapper;
import com.dev.theater.model.CinemaHall;
import com.dev.theater.model.dto.CinemaHallResponseDto;
import com.dev.theater.service.CinemaHallService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallMapper cinemaHallMapper;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public CinemaHallController(CinemaHallMapper cinemaHallMapper,
                                CinemaHallService cinemaHallService) {
        this.cinemaHallMapper = cinemaHallMapper;
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAllCinemaHall() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapper::cinemaHallToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void addCinemaHall(CinemaHallResponseDto cinemaHallDto) {
        CinemaHall cinemaHall = cinemaHallMapper.dtoToCinemaHall(cinemaHallDto);
        cinemaHallService.add(cinemaHall);
    }
}
