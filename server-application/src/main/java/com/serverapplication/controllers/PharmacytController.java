package com.serverapplication.controllers;

import com.serverapplication.domain.Pharmacyt;
import com.serverapplication.services.PharmacytService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phar")
public class PharmacytController {
    @Autowired
    private PharmacytService pharmacytService;
    @GetMapping
    public List<Pharmacyt> phar(){
        return pharmacytService.getAll();
    }
    @PostMapping
    public List<Pharmacyt> addPhar(@RequestParam String work_start, @RequestParam String work_end, @RequestParam String phone_num, @RequestParam String comp_name,
                          @RequestParam String address, @RequestParam Integer phar_numb){
        Pharmacyt pharmacyt = new Pharmacyt(work_start, work_end, phone_num, comp_name, address, phar_numb);
        pharmacytService.save(pharmacyt);
        return pharmacytService.getAll();
    }
    @DeleteMapping(value = "{id}")
    public List<Pharmacyt> delAvail(@PathVariable("id") Long id){
        pharmacytService.delete(id);
        return  pharmacytService.getAll();
    }
    @PutMapping
    public List<Pharmacyt> updAvail(@RequestBody Pharmacyt pharmacyt){
        pharmacytService.save(pharmacyt);
        return pharmacytService.getAll();
    }
}
