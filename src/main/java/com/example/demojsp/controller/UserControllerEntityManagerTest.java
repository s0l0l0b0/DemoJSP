package com.example.demojsp.controller;

import com.example.demojsp.domain.User;
import com.example.demojsp.facility.UserFacility;
import com.example.demojsp.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerEntityManagerTest {

    @Autowired
    UserFacility userFacility;

    @GetMapping("/users/add-one")
    public void addOne(@RequestParam Long id) {
       userFacility.addOneYear(id);
    }

    @GetMapping("/users/add-two")
    public void addTwo(@RequestParam Long id) {
        final User user = userFacility.get(id).get();
        user.setAge(user.getAge() + 2);
        System.out.printf("user"  + user);
    }

    @GetMapping("/users/copy-ex")
    public void copy(@RequestParam Long id) {
        final User user = userFacility.get(id).get();
        user.setId(null);
        System.out.println(user);
        userFacility.save(user);
    }

    @GetMapping("/users/copy-dto")
    public void copyWithDTO(@RequestParam Long id) {
        final UserDTO userDTO = userFacility.getUserDto(id);
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        userFacility.save(user);
    }

}
