package com.microservice.user.domain.controllers;


import com.microservice.user.domain.dtos.CreateUserDTO;
import com.microservice.user.domain.entities.User;
import com.microservice.user.domain.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> register(@RequestBody @Valid CreateUserDTO body) {
        var user = new User();

        user.setUsername(body.username());
        user.setEmail(body.email());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
}
