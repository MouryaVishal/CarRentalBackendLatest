package com.example.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CouponExceptionController {
    @ExceptionHandler(value = com.example.exception.CouponNotFoundException.class)
    public ResponseEntity<Object> exception(com.example.exception.CouponNotFoundException exception) {
        return new ResponseEntity<>("Coupon is not found", HttpStatus.NOT_FOUND);
    }
}
