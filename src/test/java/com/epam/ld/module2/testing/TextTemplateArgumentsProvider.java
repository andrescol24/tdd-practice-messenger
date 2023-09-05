package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.domain.RuntimeInformation;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class TextTemplateArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        RuntimeInformation runtimeInformation = new RuntimeInformation();
        runtimeInformation.addValue("name", "Andres");
        runtimeInformation.addValue("projectName", "Tetris");

        return Stream.of(
                Arguments.of("<h1>Welcome #{name} to our #{projectName} project</h1>",
                        runtimeInformation,
                        "<h1>Welcome Andres to our Tetris project</h1>"
                        )
        );
    }
}
