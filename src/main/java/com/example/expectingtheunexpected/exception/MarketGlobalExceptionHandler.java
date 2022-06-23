package com.example.expectingtheunexpected.exception;

import com.example.expectingtheunexpected.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.example.expectingtheunexpected.error.ErrorCodes.UNKNOWN_ERROR;

@Slf4j
@ControllerAdvice
public class MarketGlobalExceptionHandler {

    @ExceptionHandler(MarketRuntimeException.class)
    public ResponseEntity<ErrorResponse> handleMarketRuntimeException(MarketRuntimeException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(ex.getStatus())
                .body(ErrorResponse.of(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of(UNKNOWN_ERROR, ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of(UNKNOWN_ERROR, ex.getMessage()));
    }

}
