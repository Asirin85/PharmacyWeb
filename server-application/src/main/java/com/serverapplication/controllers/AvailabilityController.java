package com.serverapplication.controllers;

import com.serverapplication.domain.Availability;
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
    public Availability getOne(@PathVariable("id") Long id) {
        return availabilityService.getById(id);
    }

    @GetMapping
    public List<Availability> avail() {
        return availabilityService.getAll();
    }

    @PostMapping
    public List<Availability> addAvail(@RequestBody Availability availability) {
        return availabilityService.save(availability);
    }

    @DeleteMapping(value = "{id}")
    public List<Availability> delAvail(@PathVariable("id") Long id) {
        return availabilityService.delete(id);
    }

    @PutMapping
    public List<Availability> updAvail(@RequestBody Availability availability) {
        return availabilityService.update(availability);
    }
}
