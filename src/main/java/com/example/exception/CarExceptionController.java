package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CarExceptionController {
    @ExceptionHandler(value = com.example.exception.CarNotFoundException.class)
    public ResponseEntity<Object> exception(com.example.exception.CarNotFoundException exception) {
        return new ResponseEntity<>("Car is not found", HttpStatus.NOT_FOUND);
    }
}