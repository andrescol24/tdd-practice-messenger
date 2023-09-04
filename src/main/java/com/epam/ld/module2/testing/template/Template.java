package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.RuntimeInformation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public abstract class Template {
    protected String text;
    protected Set<String> parameterNames;
    public Set<String> getParameterNames() {
        return parameterNames;
    }
    public String getText() {return text;}
    public Optional<String> findMissingParameter(RuntimeInformation runtimeInformation) {
        for(String parameterName : parameterNames) {
            if(runtimeInformation.getValue(parameterName) == null)
                return Optional.ofNullable(parameterName);
        }
        return Optional.empty();
    }
    protected static Set<String> readParameters(String text) {
        Set<String> parameterNames = new HashSet<>();
        for (String word : text.split(" ")) {
            if(word.length() > 3 && word.contains("#{") && word.contains("}")) {
                String contentAfterOpenBrace = word.split("#\\{")[1];
                int indexOfClosedBrace = contentAfterOpenBrace.indexOf("}");
                String parameterName = contentAfterOpenBrace.substring(0, indexOfClosedBrace);
                parameterNames.add(parameterName);
            }
        }
        return parameterNames;
    }
}
