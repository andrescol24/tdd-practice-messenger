package com.epam.ld.module2.testing.domain;

import java.util.HashMap;
import java.util.Map;

public class RuntimeInformation {
    private final Map<String, String> values;
    public RuntimeInformation() {
        values = new HashMap<>();
    }
    public void addValue(String name, String value) {
        values.put(name, value);
    }
    public String getValue(String name) {
        return values.get(name);
    }

}
