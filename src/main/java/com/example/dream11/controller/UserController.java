package com.example.dream11.controller;

import com.example.dream11.DTO.request.UpdateContestIdArrayOfUserByEmailDTO;
import com.example.dream11.DTO.request.UpdateMoneyOfUserByEmailDTO;
import com.example.dream11.DTO.response.ResponseDTO;
import com.example.dream11.DTO.response.UserResponseDTO;
import com.example.dream11.models.User;
import com.example.dream11.services.UserService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getAllUsers")
    public ResponseDTO getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserResponseDTO> userResponseDTOs = new ArrayList<UserResponseDTO>();
        for (User user : users) {
            userResponseDTOs.add(new UserResponseDTO().convertUserToUserResponseDTO(user));
        }
        return new ResponseDTO(true, false, 200, null, userResponseDTOs);
    }
    @PostMapping("/addUser")
    public ResponseDTO addUser(@RequestBody User user) {
        return new ResponseDTO(true, false, 200, null,
                new UserResponseDTO().convertUserToUserResponseDTO(userService.addUser(user)));
    }
    @PostMapping("/addMultipleUsers")
    public ResponseDTO addMultipleUsers(@RequestBody List<User> users) {
        Collection<User> addedUsers = userService.addMultipleUsers(users);
        List<UserResponseDTO> userResponseDTOs = new ArrayList<UserResponseDTO>();
        for (User user : addedUsers) {
            userResponseDTOs.add(new UserResponseDTO().convertUserToUserResponseDTO(user));
        }
        return new ResponseDTO(true, false, 200, null, userResponseDTOs);
    }
    @DeleteMapping("/deleteAllUsers")
    public ResponseDTO deleteAllUsers() {
        return new ResponseDTO(true, false, 200, null,
                userService.deleteAllUsers());
    }
    @GetMapping("/getUserByEmail")
    public ResponseDTO getUserByEmail(@RequestBody String email) {
        email.trim();
        return new ResponseDTO(true, false, 200, null,
                new UserResponseDTO().convertUserToUserResponseDTO(userService.getUserByEmail(email)));
    }

    @DeleteMapping("/deleteUserByEmail")
    public ResponseDTO deleteUserByEmail(@RequestBody String email) {
        email.trim();
        return new ResponseDTO(true, false, 200, null,
                userService.deleteUserByEmail(email));
    }

    @PutMapping("/updateMoneyOfUser")
    public ResponseDTO updateMoneyOfUser(@RequestBody UpdateMoneyOfUserByEmailDTO updateMoneyOfUserByEmailDTO) {
        User user = userService.updateMoneyOfUserByEmail(updateMoneyOfUserByEmailDTO.getEmail(),
                updateMoneyOfUserByEmailDTO.getNewMoney());
        if (user == null) {
            return new ResponseDTO<UserResponseDTO>(false, true, 404, "User not found",
                    null);
        }
        return new ResponseDTO<>(true, false, 200, null,
                new UserResponseDTO().convertUserToUserResponseDTO(user));
    }

    @PutMapping("/addContestIdToUser")
    public ResponseDTO UpdateContestIdArrayOfUserByEmail(@RequestBody UpdateContestIdArrayOfUserByEmailDTO updateContestIdArrayOfUserByEmailDTO) {
        User user = userService.UpdateContestIdArrayOfUserByEmail(updateContestIdArrayOfUserByEmailDTO.getEmail(),
                updateContestIdArrayOfUserByEmailDTO.getContestId());
        if (user == null) {
            return new ResponseDTO<>(false, true, 404, "User not found",
                    null);
        }
        return new ResponseDTO<>(true, false, 200, null,
                new UserResponseDTO().convertUserToUserResponseDTO(user));
    }

    @PutMapping("/updateUser")
    public ResponseDTO<String> updateUser(@RequestBody User user) {
        UpdateResult updateResult = userService.updateUser(user);
        if (updateResult.getUpsertedId() == null) {
            return new ResponseDTO<String>(true, false, 200,null,
                    "No new document is inserted");
        }
        return new ResponseDTO<String>(true, false, 200,null,
                "New document is inserted with upsertedId = " + updateResult.getUpsertedId());
    }
}
