package com.epam.ld.module2.testing.exception;

public class ExpectedPlaceholderException extends RuntimeException{
    public ExpectedPlaceholderException(String parameterName) {
        super(parameterName + " parameter not found in the runtime variables");
    }
}
