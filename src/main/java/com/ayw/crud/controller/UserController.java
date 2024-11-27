package com.ayw.crud.controller;

import com.ayw.crud.service.UserService;
import com.ayw.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User save(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/findById")
    public User findById(@RequestParam int id){
        return userService.findById(id);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteById")
    public void delete(@RequestParam int id){
        userService.deleteUser(id);
    }
}
