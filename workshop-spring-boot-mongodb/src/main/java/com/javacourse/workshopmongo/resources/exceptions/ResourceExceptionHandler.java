package com.javacourse.workshopmongo.resources.exceptions;

import com.javacourse.workshopmongo.services.exceptions.ObjectAlreadyExists;
import com.javacourse.workshopmongo.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serializable;
import java.time.Instant;
import java.time.format.DateTimeParseException;

@ControllerAdvice
public class ResourceExceptionHandler implements Serializable {

    @ExceptionHandler
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        int status = HttpStatus.NOT_FOUND.value();
        StandardError standardError = new StandardError(Instant.now(), status, "Resource not found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler
    public ResponseEntity<StandardError> objectAlreadyExists(ObjectAlreadyExists e, HttpServletRequest request) {
        int status = HttpStatus.BAD_REQUEST.value();
        StandardError standardError = new StandardError(Instant.now(), status, "Resource already Exists", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler
    public ResponseEntity<StandardError> invalidFormatDate(DateTimeParseException e, HttpServletRequest request) {
        int status = HttpStatus.BAD_REQUEST.value();
        StandardError standardError = new StandardError(Instant.now(), status, "Invalid date", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }
}
