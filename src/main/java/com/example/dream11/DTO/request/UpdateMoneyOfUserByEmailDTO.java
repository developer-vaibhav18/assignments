package com.example.dream11.DTO.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateMoneyOfUserByEmailDTO {
    String email;
    float newMoney;
}
