package com.syscho.boot.exception.handler;

import com.syscho.boot.exception.NoDataFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(
            Exception ex) {
        log.error(String.valueOf(ex));
        Map<String, Object> body = buildErrorResponse("Something went wrong , Try again !!");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Object> handleDbException(
            DataAccessException ex) {
        log.error(String.valueOf(ex));
        Map<String, Object> body = buildErrorResponse("Something went wrong with database query!!");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> handleNoDataFoundException(
            NoDataFoundException ex) {
        log.error(String.valueOf(ex));
        Map<String, Object> body = buildErrorResponse(ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    private Map<String, Object> buildErrorResponse(String msg) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", msg);
        return body;
    }

}
