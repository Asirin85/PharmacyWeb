package com.serverapplication.services;

import com.serverapplication.domain.Medicine;

import java.util.List;

public interface MedicineService {
    Medicine getById(Long id);

    List<Medicine> save(Medicine medicine);

    List<Medicine> delete(Long id);

    List<Medicine> getAll();

    List<Medicine> update(Medicine medicine);
}
