package com.serverapplication.controllers;

import com.serverapplication.domain.Medicine;
import com.serverapplication.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/med")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public List<Medicine> med(){
        return medicineService.getAll();
    }

    @PostMapping
    public List<Medicine> addMed(@RequestParam String med_name, @RequestParam Date expiration_date, @RequestParam String med_category,
                      @RequestParam String med_rel_form){
       Medicine medicine = new Medicine(med_name,med_category,med_rel_form,expiration_date);
       medicineService.save(medicine);
       return medicineService.getAll();
    }
    @DeleteMapping(value = "{id}")
    public List<Medicine> delAvail(@PathVariable("id") Long id){
        medicineService.delete(id);
        return  medicineService.getAll();
    }
    @PutMapping
    public List<Medicine> updAvail(@RequestBody Medicine medicine){
        medicineService.save(medicine);
        return medicineService.getAll();
    }
}