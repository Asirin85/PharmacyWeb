package com.serverapplication.services;

import com.serverapplication.domain.Availability;
import com.serverapplication.domain.Medicine;
import com.serverapplication.modelsAPI.MedicineAPI;
import com.serverapplication.repos.MedicineRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    private MedicineRepo medicineRepo;

    public MedicineServiceImpl(MedicineRepo medicineRepo) {
        this.medicineRepo = medicineRepo;
    }

    @Override
    public MedicineAPI getById(Long id) {
        return convertToAPI(medicineRepo.findById(id).get());
    }

    @Override
    public List<MedicineAPI> save(MedicineAPI medicineAPI) {
        medicineRepo.save(convertToEntity(medicineAPI));
        return getAll();
    }

    @Override
    public List<MedicineAPI> update(MedicineAPI medicineAPI) {
        medicineRepo.save(convertToEntity(medicineAPI));
        return getAll();
    }

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Medicine convertToEntity(MedicineAPI medicineAPI) {
        Medicine medicine = modelMapper.map(medicineAPI, Medicine.class);
        if (medicineAPI.getIdMed() != null) {
            medicine.setIdMed(medicineAPI.getIdMed());
            Medicine oldMed = medicineRepo.findById(medicineAPI.getIdMed()).get();
            for (Availability availability : oldMed.getAvailabilities()) {
                medicine.addAvailabilities(availability);
            }
        }
        return medicine;
    }

    @Override
    public MedicineAPI convertToAPI(Medicine medicine) {
        MedicineAPI medicineAPI = modelMapper.map(medicine, MedicineAPI.class);
        return medicineAPI;
    }

    @Override
    public List<MedicineAPI> delete(Long id) {
        medicineRepo.deleteById(id);
        return getAll();
    }

    @Override
    public List<MedicineAPI> getAll() {
        List<MedicineAPI> medicineAPIList = new ArrayList<>();
        for (Medicine medicine: medicineRepo.findAll()) {
            medicineAPIList.add(convertToAPI(medicine));
        }
        return medicineAPIList;
    }
}
