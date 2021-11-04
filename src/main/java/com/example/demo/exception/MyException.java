package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "too many users")
public class MyException extends RuntimeException {
    public MyException(){

    }
    public MyException(String message){
        super(message);
    }
}
