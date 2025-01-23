package com.project.employeemanagementsystem.ems.common.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponse {

    public static ResponseEntity<ResponseWrapper<String>> buildErrorResponse(String message, HttpStatus status){
        ResponseWrapper<String> response = new ResponseWrapper<>(null,message,HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(status).body(response);
    }

    public static<T> ResponseEntity<ResponseWrapper<T>> buildErrorResponse(T data,String message,HttpStatus status){
        ResponseWrapper<T> response = new ResponseWrapper<>(data,message,HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(status).body(response);
    }
}
