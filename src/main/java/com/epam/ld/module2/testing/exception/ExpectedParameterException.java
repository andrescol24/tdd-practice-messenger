package com.epam.ld.module2.testing.exception;

public class ExpectedParameterException extends RuntimeException{
    public ExpectedParameterException(String parameterName) {
        super(parameterName + " parameter not found in the runtime variables");
    }
}
