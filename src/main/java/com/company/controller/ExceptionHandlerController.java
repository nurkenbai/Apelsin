package com.company.controller;

import com.company.exception.GlobalException;
import com.company.exception.TokenNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler({GlobalException.class})
    public ResponseEntity<?> handleBadException(RuntimeException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler({TokenNotValidException.class})
    public ResponseEntity<?> mazgi(TokenNotValidException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}
