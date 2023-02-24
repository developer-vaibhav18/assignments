package com.example.dream11.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContestIdArrayOfUserByIdRequestDTO {
    private int userId;
    private int contestId;
}
