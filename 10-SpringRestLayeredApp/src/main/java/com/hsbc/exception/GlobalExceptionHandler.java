package com.hsbc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateStudentException.class)
    @ResponseStatus(reason = "Student Already Exists!!",code = HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleException(){
        //log the exception
    }
}
