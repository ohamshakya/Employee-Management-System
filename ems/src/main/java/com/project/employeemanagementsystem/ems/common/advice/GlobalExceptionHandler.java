package com.project.employeemanagementsystem.ems.common.advice;

import com.project.employeemanagementsystem.ems.common.exception.AlreadyExistsException;
import com.project.employeemanagementsystem.ems.common.exception.ResourceNotFoundException;
import com.project.employeemanagementsystem.ems.common.utils.ErrorResponse;
import com.project.employeemanagementsystem.ems.common.utils.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({AlreadyExistsException.class})
    public static ResponseEntity<ResponseWrapper<String>> handleAlreadyExistsException(AlreadyExistsException ex){
        log.error("Exception: Already Exists Exception");
        return ErrorResponse.buildErrorResponse(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public static ResponseEntity<ResponseWrapper<String>> handleResourceNotFoundException(ResourceNotFoundException ex){
        log.error("Exception: Resource not found exception");
        return ErrorResponse.buildErrorResponse(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
}
