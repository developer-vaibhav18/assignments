package com.example.dream11.controller;

import com.example.dream11.models.User;
import com.example.dream11.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
        return;
    }
    @PostMapping("/addMultipleUsers")
    public void addMultipleUsers(@RequestBody List<User> users) {
        userService.addMultipleUsers(users);
        return;
    }
    @DeleteMapping("/deleteAllUsers")
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }
    @GetMapping("/getUserByEmail")
    public User getUserByEmail(@RequestBody String email) {
//        System.out.println(email);
        email.trim();
        try {
            User user = userService.findUserByEmail(email);
//            System.out.println(user);
            return user;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @DeleteMapping("/deleteUserByEmail/{}")
    public User deleteUserByEmail(@RequestBody String email) {
        email.trim();
        return userService.deleteUserByEmail(email);
    }

    @PutMapping("/updateMoneyOfUser")
    public User updateMoneyOfUser(@RequestParam String email, @RequestParam float newMoney) {
        return userService.updateMoneyOfUserByEmail(email, newMoney);
    }

    @PutMapping("/addContestIdToUser")
    public User addContestIdToUser(@RequestParam String email, @RequestParam int contestId) {
        return userService.addContestIdByEmail(email, contestId);
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
