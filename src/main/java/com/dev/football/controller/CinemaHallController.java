package com.dev.football.controller;

import com.dev.football.mapper.StadiumMapper;
import com.dev.football.model.Stadium;
import com.dev.football.model.dto.StadiumRequestDto;
import com.dev.football.model.dto.StadiumResponseDto;
import com.dev.football.service.StadiumService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final StadiumMapper stadiumMapper;
    private final StadiumService stadiumService;

    @Autowired
    public CinemaHallController(StadiumMapper stadiumMapper,
                                StadiumService stadiumService) {
        this.stadiumMapper = stadiumMapper;
        this.stadiumService = stadiumService;
    }

    @GetMapping
    public List<StadiumResponseDto> getAllCinemaHall() {
        return stadiumService.getAll().stream()
                .map(stadiumMapper::cinemaHallToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void addCinemaHall(@RequestBody @Valid StadiumRequestDto stadiumRequestDto) {
        Stadium stadium = stadiumMapper.dtoToCinemaHall(stadiumRequestDto);
        stadiumService.add(stadium);
    }
}
