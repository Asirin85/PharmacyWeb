package com.serverapplication.controllers;

import com.serverapplication.modelsAPI.AvailabilityAPI;
import com.serverapplication.services.AvailabilityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/avail")
public class AvailabilityController {

    private AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @GetMapping(value = "{id}")
    public AvailabilityAPI getOne(@PathVariable("id") Long id) {
        return availabilityService.getById(id);
    }

    @GetMapping
    public List<AvailabilityAPI> avail() {
        return availabilityService.getAll();
    }

    @PostMapping
    public List<AvailabilityAPI> addAvail(@RequestBody AvailabilityAPI availabilityAPI) {
        return availabilityService.save(availabilityAPI);
    }

    @DeleteMapping(value = "{id}")
    public List<AvailabilityAPI> delAvail(@PathVariable("id") Long id) {
        return availabilityService.delete(id);
    }

    @PutMapping
    public List<AvailabilityAPI> updAvail(@RequestBody AvailabilityAPI availabilityAPI) {
        return availabilityService.update(availabilityAPI);
    }
}
