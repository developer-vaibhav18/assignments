package com.example.dream11.DTO.request;

import lombok.Data;

@Data
public class UpdateMoneyOfUserByEmailDTO {
    String email;
    float money;
}
