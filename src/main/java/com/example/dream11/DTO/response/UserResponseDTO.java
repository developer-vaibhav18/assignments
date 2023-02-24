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

    private int userId;
    private String email;
    private String name;
    private float money;
    private List<Integer> contestIdsInWhichUserParticipated;
}
