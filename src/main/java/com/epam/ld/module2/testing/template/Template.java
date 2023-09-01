package com.epam.ld.module2.testing.template;

import java.io.File;
import java.util.Set;

/**
 * The type Template.
 */
public class Template {
    private String text;
    private Set<String> parameterNames;
    public Template(File file) {

    }
    public Template(String text) {

    }
    public Set<String> getParameterNames() {
        return parameterNames;
    }

    public String getText() {
        return text;
    }
}
