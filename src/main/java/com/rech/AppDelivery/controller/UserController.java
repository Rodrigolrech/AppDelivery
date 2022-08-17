package com.rech.AppDelivery.controller;

import com.rech.AppDelivery.dto.UserDto;
import com.rech.AppDelivery.model.User;
import com.rech.AppDelivery.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilderFactory;

import java.net.URI;

@RestController
@RequestMapping()
public class UserController {

    @Autowired
    ModelMapper mapper;

    @Autowired
    UserService service;

    @PostMapping("/register")
    public ResponseEntity<UserDto> saveUser(@RequestParam UserDto user) {
        User userToSave = mapper.map(user, User.class);
        User savedUser = service.saveUser(userToSave);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
