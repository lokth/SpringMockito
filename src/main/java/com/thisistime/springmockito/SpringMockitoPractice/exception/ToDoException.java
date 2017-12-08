package com.thisistime.springmockito.SpringMockitoPractice.exception;

public class ToDoException extends Exception {

    private static final long serialVerisionUID = 1L;

    private String errorMessage;

    public ToDoException(){

    }

    public ToDoException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
