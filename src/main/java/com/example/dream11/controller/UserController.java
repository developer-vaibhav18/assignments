package com.example.dream11.controller;

import com.example.dream11.DTO.request.UpdateContestIdArrayOfUserByEmailDTO;
import com.example.dream11.DTO.request.UpdateMoneyOfUserByEmailDTO;
import com.example.dream11.DTO.response.ResponseDTO;
import com.example.dream11.DTO.response.UserResponseDTO;
import com.example.dream11.models.User;
import com.example.dream11.services.UserService;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getAllUsers")
    public ResponseDTO getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/addUser")
    public ResponseDTO addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @PostMapping("/addMultipleUsers")
    public ResponseDTO addMultipleUsers(@RequestBody List<User> users) {
        return userService.addMultipleUsers(users);
    }
    @DeleteMapping("/deleteAllUsers")
    public ResponseDTO deleteAllUsers() {
        return userService.deleteAllUsers();
    }
    @GetMapping("/getUserByEmail")
    public ResponseDTO getUserByEmail(@RequestBody String email) {
        email.trim();
        return userService.getUserByEmail(email);
    }

    @DeleteMapping("/deleteUserByEmail")
    public ResponseDTO deleteUserByEmail(@RequestBody String email) {
        email.trim();
        return userService.deleteUserByEmail(email);
    }

    @PutMapping("/updateMoneyOfUser")
    public ResponseDTO updateMoneyOfUser(@RequestBody UpdateMoneyOfUserByEmailDTO updateMoneyOfUserByEmailDTO) {
        return userService.updateMoneyOfUserByEmail(updateMoneyOfUserByEmailDTO.getEmail(),
                updateMoneyOfUserByEmailDTO.getNewMoney());
    }

    @PutMapping("/addContestIdToUser")
    public ResponseDTO UpdateContestIdArrayOfUserByEmail(@RequestBody UpdateContestIdArrayOfUserByEmailDTO updateContestIdArrayOfUserByEmailDTO) {
        return userService.UpdateContestIdArrayOfUserByEmail(updateContestIdArrayOfUserByEmailDTO.getEmail(),
                updateContestIdArrayOfUserByEmailDTO.getContestId());
    }

    @PutMapping("/updateUser")
    public ResponseDTO<String> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
