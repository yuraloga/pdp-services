package com.yuraloga.ecarservice.controller;

import com.yuraloga.ecarservice.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleException(Throwable t) {
        log.error("Error: {}", t.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleException(NotFoundException e) {
        log.warn("Entity was not found: {}", e.getMessage());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
