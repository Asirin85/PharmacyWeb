package com.serverapplication.services;

import com.serverapplication.domain.Availability;

import java.util.List;

public interface AvailabilityService {
    Availability getById(Long id);

    List<Availability> save(Availability availability);

    List<Availability> delete(Long id);

    List<Availability> getAll();

    List<Availability> update(Availability availability);
}
