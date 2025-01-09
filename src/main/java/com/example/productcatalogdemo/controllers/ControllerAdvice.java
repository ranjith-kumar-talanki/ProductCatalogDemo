package com.example.productcatalogdemo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerAdvice {

    private class JsonResponse {
        String errorMessage;

        public JsonResponse() {
        }

        public JsonResponse(String errorMessage) {
            super();
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<JsonResponse> handleException(Exception e) {
        return new ResponseEntity<JsonResponse>(new JsonResponse(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
