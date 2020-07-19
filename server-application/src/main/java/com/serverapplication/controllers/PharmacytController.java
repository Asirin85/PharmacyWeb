package com.serverapplication.controllers;

import com.serverapplication.domain.Pharmacyt;
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
    public Pharmacyt getOne(@PathVariable("id") Long id) {
        return pharmacytService.getById(id);
    }

    @GetMapping
    public List<Pharmacyt> phar() {
        return pharmacytService.getAll();
    }

    @PostMapping
    public List<Pharmacyt> addPhar(@RequestBody Pharmacyt pharmacyt) {
        return pharmacytService.save(pharmacyt);
    }

    @DeleteMapping(value = "{id}")
    public List<Pharmacyt> delAvail(@PathVariable("id") Long id) {
        return pharmacytService.delete(id);
    }

    @PutMapping
    public List<Pharmacyt> updAvail(@RequestBody Pharmacyt pharmacyt) {
        return pharmacytService.update(pharmacyt);
    }
}
