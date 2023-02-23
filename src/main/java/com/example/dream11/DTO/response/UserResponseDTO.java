package com.example.dream11.DTO.response;

import com.example.dream11.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private String email;
    private float money;
    private String name;
    private List<Integer> contestIdsInWhichUserParticipated;
    public UserResponseDTO convertUserToUserResponseDTO(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.money = user.getMoney();
        this.contestIdsInWhichUserParticipated = user.getContestIdsInWhichUserParticipated();
        return this;
    };
}
