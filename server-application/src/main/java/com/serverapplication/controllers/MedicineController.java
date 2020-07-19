package com.serverapplication.controllers;

import com.serverapplication.domain.Medicine;
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
    public Medicine getOne(@PathVariable("id") Long id) {
        return medicineService.getById(id);
    }

    @GetMapping
    public List<Medicine> med() {
        return medicineService.getAll();
    }

    @PostMapping
    public List<Medicine> addMed(@RequestBody Medicine medicines) {
        return medicineService.save(medicines);
    }

    @DeleteMapping(value = "{id}")
    public List<Medicine> delAvail(@PathVariable("id") Long id) {
        return medicineService.delete(id);
    }

    @PutMapping
    public List<Medicine> updAvail(@RequestBody Medicine medicine) {
        return medicineService.update(medicine);
    }
}