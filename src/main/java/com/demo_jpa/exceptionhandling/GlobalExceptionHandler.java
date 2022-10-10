package com.demo_jpa.exceptionhandling;

import com.demo_jpa.response.EmptyJsonBody;
import com.demo_jpa.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class})
        public ResponseEntity<Object> sqlIntegrityException() {
            return ResponseHandler.generateResponse("sql integrity exception", HttpStatus.BAD_REQUEST,  new EmptyJsonBody());
        }

        @ExceptionHandler(value = {AnyCustomException.class})
        public ResponseEntity<Object> noDataFoundException(AnyCustomException ex) {
            return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.BAD_REQUEST,  new EmptyJsonBody());
        }

    }

