package com.example.expectingtheunexpected.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private Long timestamp;
    private int code;
    private String message;

    public static ErrorResponse of(int code,String message) {
        return new ErrorResponse(code,message);
    }

    public ErrorResponse(int code, String message) {
        this.timestamp = Instant.now().toEpochMilli();
        this.code = code;
        this.message = message;
    }
}
