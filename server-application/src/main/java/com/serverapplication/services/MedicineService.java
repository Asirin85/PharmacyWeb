package com.serverapplication.services;

import com.serverapplication.domain.Medicine;

import java.util.List;

public interface MedicineService {
    Medicine getById(Long id);
    void save(Medicine medicine);
    void delete(Long id);
    List<Medicine> getAll();
}
