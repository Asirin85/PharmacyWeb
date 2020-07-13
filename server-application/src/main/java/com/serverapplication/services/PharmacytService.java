package com.serverapplication.services;

import com.serverapplication.domain.Pharmacyt;

import java.util.List;

public interface PharmacytService {
    Pharmacyt getById(Long id);
    void save(Pharmacyt pharmacyt);
    void delete(Long id);
    List<Pharmacyt> getAll();
}
