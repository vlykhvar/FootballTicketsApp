package com.dev.football.service;

import com.dev.football.model.Stadium;
import java.util.List;

public interface StadiumService {
    Stadium add(Stadium stadium);

    List<Stadium> getAll();

    Stadium findById(Long stadiumId);
}
