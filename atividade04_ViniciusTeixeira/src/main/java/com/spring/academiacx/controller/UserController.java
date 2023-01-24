package com.spring.academiacx.controller;


import com.spring.academiacx.model.ProdutoModel;
import com.spring.academiacx.model.UserModel;
import com.spring.academiacx.model.dto.UserDto;
import com.spring.academiacx.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<UserModel> response = userService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public UserModel findById(@PathVariable Long id) {

        return userService.findById(id);
    }

    @PostMapping("/save")
    public UserModel insert(@RequestBody UserModel userDto) {

        return userService.insert(userDto);
    }


    @PutMapping("/update")
    public UserModel update(@RequestBody UserModel userModel) {

        return userService.update(userModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return userService.delete(id);
    }



}

