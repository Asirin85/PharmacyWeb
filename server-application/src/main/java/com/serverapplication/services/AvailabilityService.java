package com.serverapplication.services;

import com.serverapplication.domain.Availability;
import com.serverapplication.modelsAPI.AvailabilityAPI;

import java.util.List;

public interface AvailabilityService {

    AvailabilityAPI getById(Long id);

    List<AvailabilityAPI> save(AvailabilityAPI availabilityAPI);

    List<AvailabilityAPI> delete(Long id);

    List<AvailabilityAPI> getAll();

    Availability convertToEntity(AvailabilityAPI availabilityAPI);

    AvailabilityAPI convertToAPI(Availability availability);

    List<AvailabilityAPI> update(AvailabilityAPI availabilityAPI);
}
