package com.project.ems.employeemanagementsystem.common.advice;

import com.project.ems.employeemanagementsystem.common.exception.AlreadyExistsException;
import com.project.ems.employeemanagementsystem.common.exception.ResourceNotFoundException;
import com.project.ems.employeemanagementsystem.common.utils.ErrorResponse;
import com.project.ems.employeemanagementsystem.common.utils.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({AlreadyExistsException.class})
    public ResponseEntity<ResponseWrapper<String>> handleAlreadyExistsException(AlreadyExistsException e) {
        return ErrorResponse.buildErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ResponseWrapper<String>> handleResourceNotFoundException(ResourceNotFoundException e) {
        return ErrorResponse.buildErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
