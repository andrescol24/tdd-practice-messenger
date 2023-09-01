package com.epam.ld.module2.testing.template;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Template.
 */
public class Template {
    private String text;
    private Set<String> parameterNames;
    public Template(File file) {

    }
    public Template(String text) {
        this.text = text;
        this.parameterNames = readParameters(text);
    }
    public Set<String> getParameterNames() {
        return parameterNames;
    }
    public String getText() {
        return text;
    }
    private static Set<String> readParameters(String text) {
        Set<String> parameterNames = new HashSet<>();
        for (String word : text.split(" ")) {
            if(word.length() > 3 && word.startsWith("#{") && word.endsWith("}")) {
                String parameterName = word.substring(2, word.length() - 2);
                parameterNames.add(parameterName);
            }
        }
        return parameterNames;
    }
}
