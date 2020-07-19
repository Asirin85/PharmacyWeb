package com.serverapplication.services;

import com.serverapplication.domain.Availability;
import com.serverapplication.repos.AvailabilityRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    private AvailabilityRepo availabilityRepo;

    public AvailabilityServiceImpl(AvailabilityRepo availabilityRepo) {
        this.availabilityRepo = availabilityRepo;
    }

    @Override
    public Availability getById(Long id) {
        return availabilityRepo.findById(id).get();
    }

    @Override
    public List<Availability> save(Availability availability) {
        Availability availabilityAdd = new Availability(availability.getId_med_fk(), availability.getId_phar_fk(), availability.getPrice(),
                availability.getAmount(), availability.getReceipt_date());
        availabilityRepo.save(availabilityAdd);
        return getAll();
    }

    @Override
    public List<Availability> update(Availability availability) {
        availabilityRepo.save(availability);
        return getAll();
    }

    @Override
    public List<Availability> delete(Long id) {
        availabilityRepo.deleteById(id);
        return getAll();
    }

    @Override
    public List<Availability> getAll() {
        return availabilityRepo.findAll();
    }
}
