package com.serverapplication.services;

import com.serverapplication.domain.Pharmacyt;

import java.util.List;

public interface PharmacytService {
    Pharmacyt getById(Long id);

    List<Pharmacyt> save(Pharmacyt pharmacyt);

    List<Pharmacyt> delete(Long id);

    List<Pharmacyt> getAll();

    List<Pharmacyt> update(Pharmacyt pharmacyt);
}
