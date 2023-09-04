package com.epam.ld.module2.testing.template;

/**
 * The type Template.
 */
public class TextTemplate extends Template {
    public TextTemplate(String text) {
        this.text = text;
        this.parameterNames = readParameters(text);
    }
}
