package com.serverapplication.services;

import com.serverapplication.domain.Medicine;
import com.serverapplication.repos.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements  MedicineService {
    @Autowired
    MedicineRepo medicineRepo;
    @Override
    public Medicine getById(Long id) {
        return medicineRepo.getOne(id);
    }

    @Override
    public void save(Medicine medicine) {
        medicineRepo.save(medicine);
    }

    @Override
    public void delete(Long id) {
        medicineRepo.deleteById(id);
    }

    @Override
    public List<Medicine> getAll() {
        return medicineRepo.findAll();
    }
}
