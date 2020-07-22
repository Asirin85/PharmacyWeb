package com.serverapplication.services;

import com.serverapplication.domain.Availability;
import com.serverapplication.modelsAPI.AvailabilityAPI;
import com.serverapplication.repos.AvailabilityRepo;
import com.serverapplication.repos.MedicineRepo;
import com.serverapplication.repos.PharmacytRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    private AvailabilityRepo availabilityRepo;
    private MedicineRepo medicineRepo;
    private PharmacytRepo pharmacytRepo;

    public AvailabilityServiceImpl(AvailabilityRepo availabilityRepo, MedicineRepo medicineRepo, PharmacytRepo pharmacytRepo) {
        this.availabilityRepo = availabilityRepo;
        this.medicineRepo = medicineRepo;
        this.pharmacytRepo = pharmacytRepo;
    }

    @Override
    public AvailabilityAPI getById(Long id) {
        return convertToAPI(availabilityRepo.findById(id).get());
    }

    @Override
    public List<AvailabilityAPI> save(AvailabilityAPI availabilityAPI) {
        availabilityRepo.save(convertToEntity(availabilityAPI));
        return getAll();
    }

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Availability convertToEntity(AvailabilityAPI availabilityAPI) {
        Availability availability = modelMapper.map(availabilityAPI, Availability.class);
        if (availabilityAPI.getIdRec() != null) {
            availability.setIdRec(availabilityAPI.getIdRec());
        }
        availability.setPharmacyt(availabilityAPI.getIdOnPhar(pharmacytRepo));
        availability.setMedicine(availabilityAPI.getIdOnMed(medicineRepo));
        return availability;
    }

    @Override
    public AvailabilityAPI convertToAPI(Availability availability) {
        AvailabilityAPI availabilityAPI = modelMapper.map(availability, AvailabilityAPI.class);
        availabilityAPI.setIdOnMed(availability.getMedicine());
        availabilityAPI.setIdOnPhar(availability.getPharmacyt());
        return availabilityAPI;
    }

    @Override
    public List<AvailabilityAPI> update(AvailabilityAPI availabilityAPI) {
        availabilityRepo.save(convertToEntity(availabilityAPI));
        return getAll();
    }

    @Override
    public List<AvailabilityAPI> delete(Long id) {
        availabilityRepo.deleteById(id);
        return getAll();
    }

    @Override
    public List<AvailabilityAPI> getAll() {
        List<AvailabilityAPI> listAPI = new ArrayList<>();
        for (Availability availabilities : availabilityRepo.findAll()) {
            listAPI.add(convertToAPI(availabilities));
        }
        return listAPI;
    }
}
