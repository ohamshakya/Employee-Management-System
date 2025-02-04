package com.project.ems.employeemanagementsystem.common.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponse {
    public static ResponseEntity<ResponseWrapper<String>> buildErrorResponse(String message, HttpStatus status) {
        ResponseWrapper<String> responseWrapper = new ResponseWrapper<>(null, message, HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(status).body(responseWrapper);
    }

    public static ResponseEntity<ResponseWrapper<String>> buildErrorResponse(String data, String message, HttpStatus status) {
        ResponseWrapper<String> responseWrapper = new ResponseWrapper<>(data, message, HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(status).body(responseWrapper);
    }
}
