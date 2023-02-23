package com.example.dream11.services;

import com.example.dream11.DTO.response.ResponseDTO;
import com.example.dream11.DTO.response.UserResponseDTO;
import com.example.dream11.models.User;
import com.example.dream11.repository.CustomUserRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private CustomUserRepository customUserRepository;
    public ResponseDTO getAllUsers() {
        List<User> users = customUserRepository.getAllUsers();
        List<UserResponseDTO> userResponseDTOs = new ArrayList<UserResponseDTO>();
        for (User user : users) {
            userResponseDTOs.add(new UserResponseDTO().convertUserToUserResponseDTO(user));
        }
        return new ResponseDTO(true, false, 200, null, userResponseDTOs);
    }
    public ResponseDTO addUser(User user) {
        return new ResponseDTO(true, false, 200, null,
                new UserResponseDTO().convertUserToUserResponseDTO(customUserRepository.addUser(user)));
    }

    public ResponseDTO addMultipleUsers(List<User> users) {
        Collection<User> addedUsers = customUserRepository.addMultipleUsers(users);
        List<UserResponseDTO> userResponseDTOs = new ArrayList<UserResponseDTO>();
        for (User user : addedUsers) {
            userResponseDTOs.add(new UserResponseDTO().convertUserToUserResponseDTO(user));
        }
        return new ResponseDTO(true, false, 200, null, userResponseDTOs);
    }

    public ResponseDTO deleteAllUsers() {
        return new ResponseDTO(true, false, 200, null,
                customUserRepository.deleteAllUsers());
    }

    public ResponseDTO getUserByEmail(String email) {
        return new ResponseDTO(true, false, 200, null,
                new UserResponseDTO().convertUserToUserResponseDTO(customUserRepository.getUserByEmail(email)));
    }

    public ResponseDTO deleteUserByEmail(String email) {
        return new ResponseDTO(true, false, 200, null,
                customUserRepository.deleteUserByEmail(email));
    }

    public ResponseDTO<String> updateUser(User user) {
        UpdateResult updateResult = customUserRepository.updateUser(user);
        if (updateResult.getUpsertedId() == null) {
            return new ResponseDTO<String>(true, false, 200,null, "No new document is inserted");
        }
        return new ResponseDTO<String>(true, false, 200,null, "New document is inserted with upsertedId = " + updateResult.getUpsertedId());
    }
    public ResponseDTO updateMoneyOfUserByEmail(String email, float newMoney) {
        User user = customUserRepository.updateMoneyOfUserByEmail(email, newMoney);
        if (user == null) {
            return new ResponseDTO<UserResponseDTO>(false, true, 404, "User not found",
                    null);
        }
        return new ResponseDTO<>(true, false, 200, null,
                new UserResponseDTO().convertUserToUserResponseDTO(user));
    }
    public ResponseDTO UpdateContestIdArrayOfUserByEmail(String email, Integer contestId) {
        User user = customUserRepository.UpdateContestIdArrayOfUserByEmailDTO(email, contestId);
        if (user == null) {
            return new ResponseDTO<>(false, true, 404, "User not found",
                    null);
        }
        return new ResponseDTO<>(true, false, 200, null,
                new UserResponseDTO().convertUserToUserResponseDTO(user));
    }
}
