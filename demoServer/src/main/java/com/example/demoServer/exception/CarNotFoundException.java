package com.example.demoServer.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(String message){
        super(message);
    }
}
