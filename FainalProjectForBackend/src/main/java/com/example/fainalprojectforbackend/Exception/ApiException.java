package com.example.fainalprojectforbackend.Exception;

public class ApiException extends  RuntimeException{
    public ApiException(String message) {
        super(message);
    }
}
