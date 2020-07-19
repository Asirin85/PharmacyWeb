package com.serverapplication.services;

import com.serverapplication.domain.Medicine;
import com.serverapplication.repos.MedicineRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    private MedicineRepo medicineRepo;

    public MedicineServiceImpl(MedicineRepo medicineRepo) {
        this.medicineRepo = medicineRepo;
    }

    @Override
    public Medicine getById(Long id) {
        return medicineRepo.findById(id).get();
    }

    @Override
    public List<Medicine> save(Medicine medicines) {
        Medicine medicineAdd = new Medicine(medicines.getMed_name(), medicines.getMed_category(), medicines.getMed_rel_form(), medicines.getExpiration_date());
        medicineRepo.save(medicineAdd);
        return getAll();
    }

    @Override
    public List<Medicine> update(Medicine medicine) {
        medicineRepo.save(medicine);
        return getAll();
    }

    @Override
    public List<Medicine> delete(Long id) {
        medicineRepo.deleteById(id);
        return getAll();
    }

    @Override
    public List<Medicine> getAll() {
        return medicineRepo.findAll();
    }
}
