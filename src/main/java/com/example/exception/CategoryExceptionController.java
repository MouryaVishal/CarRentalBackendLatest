package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryExceptionController {
    @ExceptionHandler(value = com.example.exception.CategoryNotFoundException.class)
    public ResponseEntity<Object> exception(com.example.exception.CategoryNotFoundException exception) {
        return new ResponseEntity<>("Category is not found", HttpStatus.NOT_FOUND);
    }
}