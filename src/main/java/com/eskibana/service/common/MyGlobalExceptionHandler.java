package com.eskibana.service.common;

import com.eskibana.service.api.response.ErrorResponse;
import com.eskibana.service.api.server.CarApi;
import com.eskibana.service.exception.IllegalApiParamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MyGlobalExceptionHandler {
    public static final Logger LOG = LoggerFactory.getLogger(CarApi.class);
    @ExceptionHandler(value = IllegalApiParamException.class)
    private ResponseEntity<ErrorResponse> handleIllegalApiParamException(IllegalApiParamException e){
        var message = "Exception API Param , " + e.getMessage();
        LOG.warn(message);
        var errorResponse = new ErrorResponse(message, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
