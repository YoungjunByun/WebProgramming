package com.example.exception.exception;

import com.example.exception.controller.RestApiBController;
import com.example.exception.controller.RestApiController;
import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice(basePackageClasses = { RestApiController.class, RestApiBController.class })
public class RestApiExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(Exception e){
        log.error("RestApiExceptionHandler", e);
        return ResponseEntity.status(200).build();
    }
    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(IndexOutOfBoundsException e){
        log.error("RestApiExceptionHandler kkk", e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = { NoSuchElementException.class })
    public Api noSuchElement(NoSuchElementException e){
        log.error("", e);
        return Api.builder().resultCode(String.valueOf(HttpStatus)).resultMessage().build();
    }
}