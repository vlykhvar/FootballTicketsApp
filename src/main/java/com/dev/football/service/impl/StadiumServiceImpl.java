package com.dev.football.service.impl;

import com.dev.football.dao.StadiumDao;
import com.dev.football.model.Stadium;
import com.dev.football.service.StadiumService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StadiumServiceImpl implements StadiumService {
    private final StadiumDao stadiumDao;

    @Autowired
    public StadiumServiceImpl(StadiumDao stadiumDao) {
        this.stadiumDao = stadiumDao;
    }

    @Override
    public Stadium add(Stadium stadium) {
        return stadiumDao.add(stadium);
    }

    @Override
    public List<Stadium> getAll() {
        return stadiumDao.getAll();
    }

    @Override
    public Stadium findById(Long stadiumId) {
        return stadiumDao.findById(stadiumId);
    }
}
