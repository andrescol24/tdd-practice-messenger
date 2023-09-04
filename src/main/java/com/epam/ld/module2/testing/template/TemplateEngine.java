package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.domain.RuntimeInformation;
import com.epam.ld.module2.testing.exception.ExpectedParameterException;

import java.util.Optional;

/**
 * The type Template engine.
 */
public class TemplateEngine {
    /**
     * Generate message string.
     *
     * @param template the template
     * @param runtimeInformation the runtime runtimeInformation
     * @return the string
     */
    public String generateMessage(Template template, RuntimeInformation runtimeInformation) {
        // Validates if the runtime variables has all template variables
        Optional<String> missingParameter = template.findMissingParameter(runtimeInformation);
        if(missingParameter.isPresent())
            throw new ExpectedParameterException(missingParameter.get());

        // Fills the message
        String message = template.getText();
        for(String parameter : template.getParameterNames()) {
            String replacement = String.format("#{%s}", parameter);
            message = message.replace(replacement, runtimeInformation.getValue(parameter));
        }
        return message;
    }
}
