package com.example.dream11.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {
    private boolean success;
    private boolean error;
    private int statusCode;
    private String errorMessage;
    private T data;
    public void setSuccessResponseDTO(T data) {
        success = true;
        error = false;
        statusCode = 200;
        errorMessage = null;
        this.data = data;
    }
    public void setErrorResponseDTO(String errorMessage) {
        success = false;
        error = true;
        statusCode = 404;
        this.errorMessage = errorMessage;
        data = null;
    }
}
