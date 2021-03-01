package com.dev.football.dao;

import com.dev.football.model.Stadium;
import java.util.List;

public interface StadiumDao extends GenericDao<Stadium> {
    List<Stadium> getAll();

    Stadium findById(Long stadiumId);
}
