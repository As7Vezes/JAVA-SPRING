package com.br.denys.project.controller;

import com.br.denys.project.dto.UserDTO;
import com.br.denys.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> ListAll () {
        return userService.ListAll();
    }

    @PostMapping
    public void createUser (@RequestBody UserDTO user) {
        userService.createUser(user);
    }

    @PutMapping
    public UserDTO updateUser (@RequestBody UserDTO user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
