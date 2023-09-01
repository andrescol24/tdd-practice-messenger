package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.RuntimeInformation;
import com.epam.ld.module2.testing.exception.ExpectedPlaceholderException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemplateEngineTest {

    @Test
    public void generateMessageFromTextTemplateTest() {
        Template template = new Template("<h1>Welcome #{name} to our #{projectName} project</h1>");
        RuntimeInformation runtimeInformation = new RuntimeInformation();
        runtimeInformation.addValue("name", "Andrés Morales");
        runtimeInformation.addValue("projectName", "WKH-CEMS");

        TemplateEngine templateEngine = new TemplateEngine();
        String message = templateEngine.generateMessage(template, runtimeInformation);
        assertEquals("<h1>Welcome Andrés Morales to our WKH-CEMS project</h1>", message);
    }

    @Test
    public void generateMessageFromFileTemplateTest() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        Template template = new Template(new File(classLoader.getResource("template.html").getFile()));
        RuntimeInformation runtimeInformation = new RuntimeInformation();
        runtimeInformation.addValue("name", "Andrés Morales");
        runtimeInformation.addValue("projectName", "WKH-CEMS");
        runtimeInformation.addValue("leaderName", "Pepito Perez");

        TemplateEngine templateEngine = new TemplateEngine();
        String message = templateEngine.generateMessage(template, runtimeInformation);

        assertEquals("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Hi Andrés Morales!</h1>\n" +
                "<p>Welcome to WKH-CEMS project, we hope you enjoy your new journey here.</p>\n" +
                "<p>If you have any concern do not hesitate to contact our leader Pepito Perez</p>\n" +
                "</body>\n" +
                "</html>", message);
    }

    @Test
    public void generateMessageThrowsExpectedPlaceholderException() {
        Template template = new Template("<h1>Welcome #{name} to our #{projectName} project</h1>");
        RuntimeInformation runtimeInformation = new RuntimeInformation();
        runtimeInformation.addValue("name", "Andrés Morales");

        TemplateEngine templateEngine = new TemplateEngine();
        assertThrows(
                ExpectedPlaceholderException.class,
                () -> templateEngine.generateMessage(template, runtimeInformation),
                "projectName parameter not found in the runtime variables");
    }
}
