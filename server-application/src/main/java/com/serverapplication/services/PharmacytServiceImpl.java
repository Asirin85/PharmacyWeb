package com.serverapplication.services;

import com.serverapplication.domain.Pharmacyt;
import com.serverapplication.repos.PharmacytRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacytServiceImpl implements PharmacytService{
    @Autowired
    PharmacytRepo pharmacytRepo;
    @Override
    public Pharmacyt getById(Long id) {
        return pharmacytRepo.getOne(id);
    }

    @Override
    public void save(Pharmacyt pharmacyt) {
        pharmacytRepo.save(pharmacyt);
    }

    @Override
    public void delete(Long id) {
        pharmacytRepo.deleteById(id);
    }

    @Override
    public List<Pharmacyt> getAll() {
        return pharmacytRepo.findAll();
    }
}
