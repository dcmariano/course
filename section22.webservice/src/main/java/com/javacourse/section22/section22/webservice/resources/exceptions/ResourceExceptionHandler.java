package com.javacourse.section22.section22.webservice.resources.exceptions;

import com.javacourse.section22.section22.webservice.services.exceptions.DatabaseException;
import com.javacourse.section22.section22.webservice.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = "Unable to process your request due to integrity constraints. Please check the data and try again.";

        StandardError err = new StandardError(Instant.now(), status.value(), error, message, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}