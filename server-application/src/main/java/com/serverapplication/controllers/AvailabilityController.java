package com.serverapplication.controllers;

import com.serverapplication.domain.Availability;
import com.serverapplication.services.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avail")
public class AvailabilityController {
    @Autowired
    private AvailabilityService availabilityService;

    @GetMapping
    public List<Availability> avail(){
        return availabilityService.getAll();
    }

    @PostMapping
    public List<Availability> addAvail(@RequestBody Availability availability){

        availabilityService.save(availability);
        return availabilityService.getAll();
    }
    @DeleteMapping(value = "{id}")
    public List<Availability> delAvail(@PathVariable("id") Long id){
        availabilityService.delete(id);
        return  availabilityService.getAll();
    }
    @PutMapping
    public List<Availability> updAvail(@RequestBody Availability availability){
        availabilityService.save(availability);
        return availabilityService.getAll();
    }
}
