package com.dev.theater.service.impl;

import com.dev.theater.dao.CinemaHallDao;
import com.dev.theater.library.Inject;
import com.dev.theater.library.Service;
import com.dev.theater.model.CinemaHall;
import com.dev.theater.service.CinemaHallService;
import java.util.List;

@Service
public class CinemaHallImpl implements CinemaHallService {
    @Inject
    private CinemaHallDao cinemaHallDao;

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
