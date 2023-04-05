package com.example.dream11.controller;

import com.example.dream11.DTO.request.ListOfUserRequestDTO;
import com.example.dream11.DTO.request.UpdateContestIdArrayOfUserByIdRequestDTO;
import com.example.dream11.DTO.request.UpdateMoneyOfUserByIdRequestDTO;
import com.example.dream11.DTO.request.UserRequestDTO;
import com.example.dream11.DTO.response.ResponseDTO;
import com.example.dream11.models.User;
import com.example.dream11.services.UserServiceImpl;
import com.example.dream11.transformers.ConvertorsFromDTOsToObject;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    /**
     * @return All the users
     */
    @GetMapping("/get/all")
    public ResponseDTO getAllUsers() {
        ResponseDTO responseDTO = new ResponseDTO();
        List<User> users = userService.getAllUsers();
        responseDTO.setSuccessResponseDTO(users);
        return responseDTO;
    }

    /**
     * @param userRequestDTO userRequestDTO accept all the data required to make a User object.
     *                       UserRequestDTO have email, name, money and arrayOfContestIds
     * @return ResponseDTO here will have information of added user.
     */
    @PostMapping("/create")
    public ResponseDTO addUser(@RequestBody UserRequestDTO userRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        User user = ConvertorsFromDTOsToObject.convertorFromUserRequestDTOToUser(userRequestDTO);
        User createdUser = userService.createUser(user);
        responseDTO.setSuccessResponseDTO(createdUser);
        return responseDTO;
    }

    /**
     * @param listOfUserRequestDTO
     * @return ResponseDTO here will contain a collection of users got added
     */
    @PostMapping("/create/all")
    public ResponseDTO createAllUsers(@RequestBody ListOfUserRequestDTO listOfUserRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        List<User> users = ConvertorsFromDTOsToObject.convertorFromListOfUserRequestDTOToListOfUser(
                listOfUserRequestDTO);
        Collection<User> addedUsers = userService.createAllUsers(users);
        responseDTO.setSuccessResponseDTO(addedUsers);
        return responseDTO;
    }

    /**
     * @return ResponseDTO here will return DeleteResult that contains count of all users deleted.
     */
    @DeleteMapping("/delete/all")
    public ResponseDTO deleteAllUsers() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccessResponseDTO(userService.deleteAllUsers());
        return responseDTO;
    }

    /**
     * @param id it is userId to be found
     * @return user having userId that is in the param
     */
    @GetMapping("/get/id/{id}")
    public ResponseDTO getUserById(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO();
        User user = userService.getUserByUserId(id);
        responseDTO.setSuccessResponseDTO(user);
        return responseDTO;
    }

    /**
     * @param id it is the userId of user who has to deleted
     * @return delete user with given userId
     */
    @DeleteMapping("/delete/id/{id}")
    public ResponseDTO deleteUserById(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccessResponseDTO(userService.deleteUserByUserId(id));
        return responseDTO;
    }

    /**
     * This method updates money of user with given userId.
     *
     * @param updateMoneyOfUserByIdRequestDTO contains email id of the user whose money needs to be updated
     * @return ResponseDTO here contains the user whose money is updated
     */
    @PutMapping("/update/money")
    public ResponseDTO updateMoneyOfUser(@RequestBody UpdateMoneyOfUserByIdRequestDTO updateMoneyOfUserByIdRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        User user = userService.updateMoneyOfUserById(updateMoneyOfUserByIdRequestDTO.getId(),
                updateMoneyOfUserByIdRequestDTO.getNewMoney());
        if (user == null) {
            responseDTO.setErrorResponseDTO("User not found!!");
        } else {
            responseDTO.setSuccessResponseDTO(user);
        }
        return responseDTO;
    }

    /**
     * This method add given contest Id to contestIdArray of user
     *
     * @param updateContestIdArrayOfUserByIdDTO
     * @return ResponseDTO return user whose contestId array got updated
     */
    @PutMapping("/update/contestId")
    public ResponseDTO updateContestIdArrayOfUser(
            @RequestBody UpdateContestIdArrayOfUserByIdRequestDTO updateContestIdArrayOfUserByIdDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        User user = userService.updateContestIdArrayOfUserById(updateContestIdArrayOfUserByIdDTO.getId(),
                updateContestIdArrayOfUserByIdDTO.getContestId());
        if (user == null) {
            responseDTO.setErrorResponseDTO("User not found!!");
        } else {
            responseDTO.setSuccessResponseDTO(user);
        }
        return responseDTO;
    }

    /**
     * This method update user object using upsert method
     *
     * @param user
     * @return ResponseDTO return a String indicating whether new data is inserted or existing is updated.
     */
    @PutMapping("/update")
    public ResponseDTO updateUser(@RequestBody User user) {
        ResponseDTO responseDTO = new ResponseDTO<>();
        UpdateResult updateResult = userService.updateUser(user);
        if (updateResult.getUpsertedId() == null) {
            responseDTO.setSuccessResponseDTO(new String("Data updated, no new document is inserted"));
        } else {
            responseDTO.setSuccessResponseDTO(
                    new String("New document is inserted with upsertedId = " + updateResult.getUpsertedId()));
        }
        return responseDTO;
    }
}
