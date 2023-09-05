package com.epam.ld.module2.testing.template;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TemplateOutputManager {
    private final Template template;
    public TemplateOutputManager(Template template) {
        this.template = template;
    }
    public void writeResult(String message) throws IOException {
        if (template instanceof FileTemplate) {
            FileTemplate fileTemplate = (FileTemplate) template;
            Files.write(new File(fileTemplate.getOutputFilePath()).toPath(), message.getBytes());
        } else {
            System.out.println(message);
        }
    }
}
