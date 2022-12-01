package com.example.websample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor  // lombok - 자동 생성자
@Data  // lombok - getter/setter
public class ErrorResponse {
    private String errorCode;
    private String message;
}
