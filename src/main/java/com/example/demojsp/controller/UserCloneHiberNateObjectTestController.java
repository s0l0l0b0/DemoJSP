package com.example.demojsp.controller;

import com.example.demojsp.domain.User;
import com.example.demojsp.facility.UserFacility;
import com.example.demojsp.model.ActionResponse;
import com.example.demojsp.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserCloneHiberNateObjectTestController {

    private static final Logger logger = LoggerFactory.getLogger(UserCloneHiberNateObjectTestController.class);

    @Autowired
    UserFacility userFacility;

    @GetMapping(value = {"", "/"})
    public List<User> getAllUser() {
        return userFacility.getAll();
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<ActionResponse> createOneUser(@RequestBody UserDTO userDTO) {
        try {
            userFacility.save(userDTO);
            return ResponseEntity.ok(new ActionResponse().result(true).message("User Created Successfully"));
        } catch (Exception e) {
            logger.error("Unable to save user!", e);
            return ResponseEntity.unprocessableEntity().body(new ActionResponse().result(false).message(e.getMessage()));
        }
    }

    /**
     * Detach entity persisting is working for simple entity object
     */
    @GetMapping(value = "/detach/test")
    public void test() {
        final Optional<User> byId = userFacility.get(1L);
        if (byId.isPresent()) {
            User user = byId.get();
            System.out.println(user);
            userFacility.getEntityManager().detach(user);
            user.setId(null);
            System.out.println(user);
            userFacility.save(user);
        }
    }

    /**
     * Dto test is working or simple entity object
     */
    @GetMapping(value = "/dto/test")
    public void dtoTest() {
        final Optional<User> userOptional = userFacility.get(2L);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getName());
            userDTO.setAge(user.getAge());
            userFacility.save(userDTO);
        }
    }
}
