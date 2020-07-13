package com.serverapplication.services;

import com.serverapplication.domain.Availability;

import java.util.List;

public interface AvailabilityService {
    Availability getById(Long id);
    void save(Availability availability);
    void delete(Long id);
    List<Availability> getAll();
}
