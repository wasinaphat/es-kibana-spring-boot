package com.eskibana.service.exception;

public class IllegalApiParamException extends RuntimeException{
    private static final long serialVersionUID = 1234567L;
    public IllegalApiParamException(String s){
        super(s);
    }
}
