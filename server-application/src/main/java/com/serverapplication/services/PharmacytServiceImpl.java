package com.serverapplication.services;

import com.serverapplication.domain.Pharmacyt;
import com.serverapplication.repos.PharmacytRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacytServiceImpl implements PharmacytService {
    private PharmacytRepo pharmacytRepo;

    public PharmacytServiceImpl(PharmacytRepo pharmacytRepo) {
        this.pharmacytRepo = pharmacytRepo;
    }

    @Override
    public Pharmacyt getById(Long id) {
        return pharmacytRepo.findById(id).get();
    }

    @Override
    public List<Pharmacyt> save(Pharmacyt pharmacyt) {
        pharmacytRepo.save(pharmacyt);
        return getAll();
    }

    @Override
    public List<Pharmacyt> update(Pharmacyt pharmacyt) {
        pharmacytRepo.save(pharmacyt);
        return getAll();
    }

    @Override
    public List<Pharmacyt> delete(Long id) {
        pharmacytRepo.deleteById(id);
        return getAll();
    }

    @Override
    public List<Pharmacyt> getAll() {
        return pharmacytRepo.findAll();
    }
}
