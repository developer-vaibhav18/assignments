package com.example.dream11.DTO.response;

import com.example.dream11.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private int userId;
    private String email;
    private String name;
    public UserResponseDTO convertUserToUserResponseDTO(User user) {
        this.email = user.getEmail();
        this.userId = user.getUserId();
        this.name = user.getName();
        return this;
    };
}
