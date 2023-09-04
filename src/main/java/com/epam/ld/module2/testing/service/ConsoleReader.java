package com.epam.ld.module2.testing.service;

import com.epam.ld.module2.testing.domain.RuntimeInformation;

import java.util.Scanner;
import java.util.Set;

public class ConsoleReader {
    private final Scanner scanner;
    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    public RuntimeInformation readParameters(Set<String> parameterNames) {
        RuntimeInformation runtimeInformation = new RuntimeInformation();
        for(String parameterName : parameterNames) {
            String value = readParameter(parameterName);
            runtimeInformation.addValue(parameterName, value);
        }
        return runtimeInformation;
    }

    public String readParameter(String parameterName) {
        System.out.printf("insert the value of #{%s}: ", parameterName);
        return scanner.nextLine();
    }
}
