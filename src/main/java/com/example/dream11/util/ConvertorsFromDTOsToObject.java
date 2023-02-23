package com.example.dream11.util;

import com.example.dream11.DTO.request.ListOfUserRequestDTO;
import com.example.dream11.DTO.request.UserRequestDTO;
import com.example.dream11.models.User;

import java.util.ArrayList;
import java.util.List;

public class ConvertorsFromDTOsToObject {
    public static User convertorFromUserRequestDTOToUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUserId(userRequestDTO.getUserId());
        user.setEmail(userRequestDTO.getEmail());
        user.setName(userRequestDTO.getName());
        user.setMoney(userRequestDTO.getMoney());
        user.setContestIdsInWhichUserParticipated(userRequestDTO.getContestIdsInWhichUserParticipated());
        return user;
    }

    public static List<User> convertorFromListOfUserRequestDTOToListOfUser(ListOfUserRequestDTO listOfUserRequestDTO) {
        List<User> users = new ArrayList<User>();
        for (UserRequestDTO userRequestDTO : listOfUserRequestDTO.getUserRequestDTOs()) {
            users.add(convertorFromUserRequestDTOToUser(userRequestDTO));
        }
        return users;
    }
}
