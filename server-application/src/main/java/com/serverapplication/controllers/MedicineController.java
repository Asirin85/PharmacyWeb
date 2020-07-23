package com.serverapplication.controllers;

import com.serverapplication.modelsAPI.MedicineAPI;
import com.serverapplication.services.MedicineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/med")
public class MedicineController {

    private MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping(value = "{id}")
    public MedicineAPI getOne(@PathVariable("id") Long id) {
        return medicineService.getById(id);
    }

    @GetMapping
    public List<MedicineAPI> med() {
        return medicineService.getAll();
    }

    @PostMapping
    public List<MedicineAPI> addMed(@RequestBody MedicineAPI medicineAPI) {
        return medicineService.save(medicineAPI);
    }

    @DeleteMapping(value = "{id}")
    public List<MedicineAPI> delAvail(@PathVariable("id") Long id) {
        return medicineService.delete(id);
    }

    @PutMapping
    public List<MedicineAPI> updAvail(@RequestBody MedicineAPI medicineAPI) {
        return medicineService.update(medicineAPI);
    }
}