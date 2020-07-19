package com.serverapplication.authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticateController {

    @GetMapping(value = "/login", produces = "application/json")
    public Boolean validateLogin(@RequestParam String username, @RequestParam String password) {
        return username.equals("user") && password.equals("password");
    }
}
