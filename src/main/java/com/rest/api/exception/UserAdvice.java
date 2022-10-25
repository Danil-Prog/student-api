package com.rest.api.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response> handleException(ResourceNotFoundException exception) {
        Response response = new Response(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
