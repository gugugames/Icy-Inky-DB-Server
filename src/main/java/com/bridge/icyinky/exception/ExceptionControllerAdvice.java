package com.bridge.icyinky.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionControllerAdvice {

    //서비스에서 null return할 경우
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity handleServerException(Exception e) {
        String serverException = e.getMessage();

        return new ResponseEntity<>(serverException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //requestBody가 비어있일 경우
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity handleValueEmptyException(MethodArgumentNotValidException e) {
        String valueEmptyException = e.getMessage();
        return new ResponseEntity<>(valueEmptyException, HttpStatus.BAD_REQUEST);
    }


}
