package com.epam.ld.module2.testing.template;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateTest {

    @Test
    public void textTemplateHasExpectedTextTest() {
        String text = "<h1>Welcome #{name} to our #{projectName} project</h1>";
        TextTemplate template = new TextTemplate(text);
        assertEquals(text, template.getText());
    }
    @Test
    public void textTemplateHasExpectedParametersTest() {
        String text = "<h1>Welcome #{name} to our #{projectName} project</h1>";
        Set<String> expectedParameters = new HashSet<>(Arrays.asList("name", "projectName"));

        TextTemplate template = new TextTemplate(text);

        assertEquals(expectedParameters, template.getParameterNames());
    }
    @Test
    public void fileTemplateHasExpectedTextTest() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();

        Template template = new FileTemplate(classLoader.getResource("template.html").getFile(), "");

        assertEquals("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Hi #{name}!</h1>\n" +
                "<p>Welcome to #{projectName} project, we hope you enjoy your new journey here.</p>\n" +
                "<p>If you have any concern do not hesitate to contact our leader #{leaderName}</p>\n" +
                "</body>\n" +
                "</html>", template.getText());
    }

    @Test
    public void fileTemplateHasExpectedParametersTest() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        Set<String> expectedParameters = new HashSet<>(Arrays.asList("name", "projectName", "leaderName"));

        Template template = new FileTemplate(classLoader.getResource("template.html").getFile(), "");

        assertEquals(expectedParameters, template.getParameterNames());
    }
}
