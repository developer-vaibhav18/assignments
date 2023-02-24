package com.example.dream11.DTO.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ListOfUserResponseDTO {

    List<UserResponseDTO> userResponseDTOs;
}
