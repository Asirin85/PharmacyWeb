package com.serverapplication.services;

import com.serverapplication.domain.Medicine;
import com.serverapplication.modelsAPI.MedicineAPI;

import java.util.List;

public interface MedicineService {
    MedicineAPI getById(Long id);

    List<MedicineAPI> save(MedicineAPI medicineAPI);

    List<MedicineAPI> delete(Long id);

    List<MedicineAPI> getAll();

    List<MedicineAPI> update(MedicineAPI medicineAPI);

    Medicine convertToEntity(MedicineAPI medicineAPI);

    MedicineAPI convertToAPI(Medicine medicine);
}
