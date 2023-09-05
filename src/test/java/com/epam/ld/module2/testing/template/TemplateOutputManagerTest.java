package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.domain.RuntimeInformation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateOutputManagerTest {
    @TempDir
    private File tempFile;

    @Test
    public void saveTemplateTest () throws IOException, InterruptedException {
        ClassLoader classLoader = getClass().getClassLoader();
        String inputPath = classLoader.getResource("template.html").getFile();
        File outputFile = new File(tempFile, "template_out.html");
        Template template = new FileTemplate(inputPath, outputFile.getPath());
        TemplateOutputManager templateOutputManager = new TemplateOutputManager();
        RuntimeInformation runtimeInformation = new RuntimeInformation();
        runtimeInformation.addValue("name", "Andres");
        runtimeInformation.addValue("projectName", "Tetris");
        runtimeInformation.addValue("leaderName", "Pepito Perez");
        TemplateEngine engine = new TemplateEngine();
        String message = engine.generateMessage(template, runtimeInformation);

        templateOutputManager.writeResult(template, message);

        String result = Files.readString(outputFile.toPath());
        assertEquals("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Hi Andres!</h1>\n" +
                "<p>Welcome to Tetris project, we hope you enjoy your new journey here.</p>\n" +
                "<p>If you have any concern do not hesitate to contact our leader Pepito Perez</p>\n" +
                "</body>\n" +
                "</html>", result);
    }
}
