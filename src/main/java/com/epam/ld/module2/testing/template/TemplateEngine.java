package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.RuntimeInformation;

/**
 * The type Template engine.
 */
public class TemplateEngine {
    /**
     * Generate message string.
     *
     * @param template the template
     * @param information the runtime information
     * @return the string
     */
    public String generateMessage(Template template, RuntimeInformation information) {
        String message = template.getText();
        for(String parameter : template.getParameterNames()) {
            String replacement = String.format("#{%s}", parameter);
            message = message.replace(replacement, information.getValue(parameter));
        }
        return message;
    }
}
