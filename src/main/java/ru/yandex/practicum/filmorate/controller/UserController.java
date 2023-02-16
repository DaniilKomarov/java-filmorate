package ru.yandex.practicum.filmorate.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.*;

import lombok.extern.slf4j.Slf4j;
import ru.yandex.practicum.filmorate.service.UserService;


import java.util.List;

@Slf4j
@RestController
public class UserController {
    UserService userService = new UserService();

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.getUsers();
    }
    @PostMapping(value = "/users")
    public User create(@RequestBody User user){
        return userService.createUser(user);
    }
    @PutMapping("/users")
    public User put(@RequestBody User user){
        return userService.updateUser(user);
    }

}
