package com.epam.ld.module2.testing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ConsoleReader {
    private final Scanner scanner;
    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    public Map<String, String> readParameters(Set<String> parameterNames) {
        Map<String, String> parameters = new HashMap<>();
        for(String parameterName : parameterNames) {
            String value = readParameter(parameterName);
            parameters.put(parameterName, value);
        }
        return parameters;
    }

    public String readParameter(String parameterName) {
        System.out.printf("insert the value of #{%s}: ", parameterName);
        return scanner.nextLine();
    }
}
