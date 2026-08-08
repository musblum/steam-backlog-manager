package com.salem.steambacklogmanager.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleGameNotFound(
            GameNotFoundException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("status", 404);
        body.put("message", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(body);
    }

}
