package com.example.demojsp.controller;

import com.example.demojsp.domain.User;
import com.example.demojsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColumnAliasWithHQLTest {
    private final UserRepository userRepository;

    @Autowired
    public ColumnAliasWithHQLTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/renaming/test")
    public void renamingTest() {
        final Long ageSum = userRepository.getUser();
        System.out.println(ageSum);
    }
}
