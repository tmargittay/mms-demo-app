package com.tsystems.mms.demoapp.user.exception;

public class InvalidEmailException extends Exception{
    @Override
    public String getMessage() {
        return "The email you entered is invalid!";
    }
}
