package com.batch.exception;

public class WrongUserDetailsException extends Exception{
    public WrongUserDetailsException(String message) {
        super(message);
    }
}
