package com.serverapplication.services;

import com.serverapplication.domain.Availability;
import com.serverapplication.domain.Pharmacyt;
import com.serverapplication.modelsAPI.PharmacytAPI;
import com.serverapplication.repos.PharmacytRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PharmacytServiceImpl implements PharmacytService {
    private PharmacytRepo pharmacytRepo;

    public PharmacytServiceImpl(PharmacytRepo pharmacytRepo) {
        this.pharmacytRepo = pharmacytRepo;
    }

    @Override
    public PharmacytAPI getById(Long id) {
        return convertToAPI(pharmacytRepo.findById(id).get());
    }

    @Override
    public List<PharmacytAPI> save(PharmacytAPI pharmacytAPI) {
        pharmacytRepo.save(convertToEntity(pharmacytAPI));
        return getAll();
    }

    @Override
    public List<PharmacytAPI> update(PharmacytAPI pharmacytAPI) {
        pharmacytRepo.save(convertToEntity(pharmacytAPI));
        return getAll();
    }

    @Override
    public List<PharmacytAPI> delete(Long id) {
        pharmacytRepo.deleteById(id);
        return getAll();
    }

    @Override
    public List<PharmacytAPI> getAll() {
        List<PharmacytAPI> pharmacytAPIList = pharmacytRepo.findAll().stream().map(this::convertToAPI).collect(Collectors.toList());
        return pharmacytAPIList;
    }

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Pharmacyt convertToEntity(PharmacytAPI pharmacytAPI) {
        Pharmacyt pharmacyt = modelMapper.map(pharmacytAPI, Pharmacyt.class);
        if (pharmacytAPI.getIdPhar() != null) {
            pharmacyt.setIdPhar(pharmacytAPI.getIdPhar());
            Pharmacyt oldPhar = pharmacytRepo.findById(pharmacytAPI.getIdPhar()).get();
            for (Availability availability : oldPhar.getAvailabilities()) {
                pharmacyt.addAvailabilities(availability);
            }
        }
        return pharmacyt;
    }

    @Override
    public PharmacytAPI convertToAPI(Pharmacyt pharmacyt) {
        PharmacytAPI pharmacytAPI = modelMapper.map(pharmacyt, PharmacytAPI.class);
        return pharmacytAPI;
    }
}
