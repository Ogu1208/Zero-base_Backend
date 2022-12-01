package com.example.websample.dto;

import com.example.websample.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor  // lombok - 자동 생성자
@Data  // lombok - getter/setter
public class ErrorResponse {
    private ErrorCode errorCode;
    private String message;
}
