package com.epam.ld.module2.testing.template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileTemplate extends Template{
    private final String outputFilePath;
    public FileTemplate(String inputFilePath, String outputFilePath) throws IOException {
        this.outputFilePath = outputFilePath;
        this.text = readFile(new File(inputFilePath));
        this.parameterNames = readParameters(text);
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
