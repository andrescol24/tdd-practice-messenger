package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.RuntimeInformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * The type Template.
 */
public class Template {
    private String text;
    private Set<String> parameterNames;
    public Template(File file) throws IOException {
        this.text = readFile(file);
        this.parameterNames = readParameters(text);
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
    public Optional<String> findMissingParameter(RuntimeInformation runtimeInformation) {
        for(String parameterName : parameterNames) {
            if(runtimeInformation.getValue(parameterName) == null)
                return Optional.ofNullable(parameterName);
        }
        return Optional.empty();
    }
    private static Set<String> readParameters(String text) {
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
    private String readFile(File file) throws IOException {
        StringBuilder textBuild = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            textBuild.append(br.readLine());
            while((line = br.readLine()) != null) {
                textBuild.append("\n");
                textBuild.append(line);
            }
        }
        return textBuild.toString();
    }
}
