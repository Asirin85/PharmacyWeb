package com.serverapplication.controllers;

import com.serverapplication.modelsAPI.PharmacytAPI;
import com.serverapplication.services.PharmacytService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/phar")
public class PharmacytController {

    private PharmacytService pharmacytService;

    public PharmacytController(PharmacytService pharmacytService) {
        this.pharmacytService = pharmacytService;
    }

    @GetMapping(value = "{id}")
    public PharmacytAPI getOne(@PathVariable("id") Long id) {
        return pharmacytService.getById(id);
    }

    @GetMapping
    public List<PharmacytAPI> phar() {
        return pharmacytService.getAll();
    }

    @PostMapping
    public List<PharmacytAPI> addPhar(@RequestBody PharmacytAPI pharmacytAPI) {
        return pharmacytService.save(pharmacytAPI);
    }

    @DeleteMapping(value = "{id}")
    public List<PharmacytAPI> delAvail(@PathVariable("id") Long id) {
        return pharmacytService.delete(id);
    }

    @PutMapping
    public List<PharmacytAPI> updAvail(@RequestBody PharmacytAPI pharmacytAPI) {
        return pharmacytService.update(pharmacytAPI);
    }
}
