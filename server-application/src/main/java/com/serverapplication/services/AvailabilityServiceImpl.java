package com.serverapplication.services;

import com.serverapplication.domain.Availability;
import com.serverapplication.repos.AvailabilityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AvailabilityServiceImpl implements AvailabilityService {
    @Autowired
    AvailabilityRepo availabilityRepo;
    @Override
    public Availability getById(Long id) {
        return availabilityRepo.getOne(id);
    }

    @Override
    public void save(Availability availability) {
        availabilityRepo.save(availability);
    }

    @Override
    public void delete(Long id) {
        availabilityRepo.deleteById(id);
    }

    @Override
    public List<Availability> getAll() {
        return availabilityRepo.findAll();
    }
}
