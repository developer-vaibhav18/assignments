package com.example.dream11.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private int id;
    private String email;
    private String name;
    private float money;
    private List<Integer> contestIdsInWhichUserParticipated;
}
