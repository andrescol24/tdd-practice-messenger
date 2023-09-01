package com.epam.ld.module2.testing.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TemplateTest {

    @Test
    public void templateTextTest() {
        String text = "<h1>Welcome #{name} to our #{projectName} project</h1>";
        Template template = new Template(text);
        assertEquals(text, template.getText());
    }
}
