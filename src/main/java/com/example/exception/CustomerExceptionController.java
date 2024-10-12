package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomerExceptionController {
    @ExceptionHandler(value = com.example.exception.CustomerNotFoundException.class)
    public ResponseEntity<Object> exception(com.example.exception.CustomerNotFoundException exception) {
        return new ResponseEntity<>("Customer is not found", HttpStatus.NOT_FOUND);
    }
}