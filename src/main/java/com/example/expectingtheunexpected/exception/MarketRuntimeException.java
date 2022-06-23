package com.example.expectingtheunexpected.exception;

import com.example.expectingtheunexpected.error.ErrorCodes;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MarketRuntimeException extends RuntimeException{
    private final HttpStatus status;
    private final int code;
    private final String message;

    public MarketRuntimeException(HttpStatus status, int code, String message){
        super(message);
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public MarketRuntimeException(String message){
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.code = ErrorCodes.UNKNOWN_ERROR;
        this.message = message;
    }

}
