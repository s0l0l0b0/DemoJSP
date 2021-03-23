package com.example.demojsp.controller;


import com.example.demojsp.facility.UserFacility;
import com.example.demojsp.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserControllerProjections {

    @Autowired
    UserFacility userFacility;

    @GetMapping("/projections/test")
    public UserDTO getUserDto(@RequestParam Long id) {
        return userFacility.getUserDto(id);
    }
}
