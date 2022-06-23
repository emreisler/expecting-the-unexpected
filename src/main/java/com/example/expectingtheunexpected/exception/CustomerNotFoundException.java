package com.example.expectingtheunexpected.exception;

import org.springframework.http.HttpStatus;

import static com.example.expectingtheunexpected.error.ErrorCodes.CUSTOMER_NOT_FOUND;

public class CustomerNotFoundException extends MarketRuntimeException{

    public CustomerNotFoundException(){
        super(HttpStatus.BAD_REQUEST,CUSTOMER_NOT_FOUND,"Customer not found!");
    }

}
