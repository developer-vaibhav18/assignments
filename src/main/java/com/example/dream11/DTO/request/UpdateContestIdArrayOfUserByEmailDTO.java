package com.example.dream11.DTO.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateContestIdArrayOfUserByEmailDTO {
    private String email;
    private int contestId;
}
