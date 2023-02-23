package com.example.dream11.util;

import com.example.dream11.DTO.response.ListOfUserResponseDTO;
import com.example.dream11.DTO.response.UserResponseDTO;
import com.example.dream11.models.User;

import java.util.ArrayList;
import java.util.List;

public class ConvertorsFromObjectToDTO {
    public static UserResponseDTO convertFromUserToUserResponseDTO(User user) {
        return new UserResponseDTO(user.getUserId(),
                                   user.getEmail(),
                                   user.getName(),
                                   user.getMoney(),
                                   user.getContestIdsInWhichUserParticipated());
    }
    public static ListOfUserResponseDTO convertFromListOfUserToListOfUserResponseDTO(List<User> users) {
        List<UserResponseDTO> userResponseDTOs = new ArrayList<>();
        for (User user : users) {
            userResponseDTOs.add(convertFromUserToUserResponseDTO(user));
        }
        ListOfUserResponseDTO listOfUserResponseDTO = new ListOfUserResponseDTO();
        listOfUserResponseDTO.setUserResponseDTOs(userResponseDTOs);
        return listOfUserResponseDTO;
    }
}
