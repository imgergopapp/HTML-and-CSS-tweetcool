package com.codecool.web.service;

public class InvalidFormException extends RuntimeException{

    public InvalidFormException(String msg) {
        super(msg);
    }
}
