package com.example.dream11.controller;

import com.example.dream11.DTO.request.ListOfUserRequestDTO;
import com.example.dream11.DTO.request.UpdateContestIdArrayOfUserByIdRequestDTO;
import com.example.dream11.DTO.request.UpdateMoneyOfUserByIdRequestDTO;
import com.example.dream11.DTO.request.UserRequestDTO;
import com.example.dream11.DTO.response.ResponseDTO;
import com.example.dream11.models.User;
import com.example.dream11.services.UserService;
import com.example.dream11.util.ConvertorsFromDTOsToObject;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * @return All the users
     */
    @GetMapping("/getAllUsers")
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
    @PostMapping("/addUser")
    public ResponseDTO addUser(@RequestBody UserRequestDTO userRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        User user = ConvertorsFromDTOsToObject.convertorFromUserRequestDTOToUser(userRequestDTO);
        //        System.out.println(user);
        User addedUser = userService.addUser(user);
        responseDTO.setSuccessResponseDTO(addedUser);
        return responseDTO;
    }

    /**
     * @param listOfUserRequestDTO
     * @return ResponseDTO here will contain a collection of users got added
     */
    @PostMapping("/addMultipleUsers")
    public ResponseDTO addMultipleUsers(@RequestBody ListOfUserRequestDTO listOfUserRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        List<User> users = ConvertorsFromDTOsToObject.convertorFromListOfUserRequestDTOToListOfUser(
                listOfUserRequestDTO);
        Collection<User> addedUsers = userService.addMultipleUsers(users);
        responseDTO.setSuccessResponseDTO(addedUsers);
        return responseDTO;
    }

    /**
     * @return ResponseDTO here will return DeleteResult that contains count of all users deleted.
     */
    @DeleteMapping("/deleteAllUsers")
    public ResponseDTO deleteAllUsers() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccessResponseDTO(userService.deleteAllUsers());
        return responseDTO;
    }

    /**
     * @param id it is userId to be found
     * @return user having userId that is in the param
     */
    @GetMapping("/getUserById")
    public ResponseDTO getUserById(@RequestParam int id) {
        ResponseDTO responseDTO = new ResponseDTO();
        User user = userService.getUserByUserId(id);
        responseDTO.setSuccessResponseDTO(user);
        return responseDTO;
    }

    /**
     * @param id it is the userId of user who has to deleted
     * @return delete user with given userId
     */
    @DeleteMapping("/deleteUserById")
    public ResponseDTO deleteUserById(@RequestParam int id) {
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
    @PutMapping("/updateMoneyOfUser")
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
    @PutMapping("/addContestIdToUser")
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
    @PutMapping("/updateUser")
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
