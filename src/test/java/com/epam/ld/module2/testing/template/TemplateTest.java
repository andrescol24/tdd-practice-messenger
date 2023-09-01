package com.epam.ld.module2.testing.template;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TemplateTest {

    @Test
    public void textTemplateHasExpectedTextTest() {
        String text = "<h1>Welcome #{name} to our #{projectName} project</h1>";
        Template template = new Template(text);
        assertEquals(text, template.getText());
    }
    @Test
    public void textTemplateHasExpectedParametersTest() {
        String text = "<h1>Welcome #{name} to our #{projectName} project</h1>";
        Set<String> expectedParameters = new HashSet<>(Arrays.asList("name", "projectName"));

        Template template = new Template(text);

        assertEquals(expectedParameters, template.getParameterNames());
    }
}
