package com.epam.ld.module2.testing.service;

import com.epam.ld.module2.testing.domain.RuntimeInformation;
import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TextTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class ConsoleReaderTest {
    @Test
    public void testReadParameters() {
        Template template = new TextTemplate("<h1>Hello #{name}, this is a greating from #{team} team</h1>");
        ConsoleReader consoleReader = spy(new ConsoleReader());
        doReturn("Andres").when(consoleReader).readParameter(eq("name"));
        doReturn("Tetris").when(consoleReader).readParameter(eq("team"));

        RuntimeInformation runtimeInformation = consoleReader.readParameters(template.getParameterNames());

        assertEquals("Andres", runtimeInformation.getValue("name"));
        assertEquals("Tetris", runtimeInformation.getValue("team"));
        verify(consoleReader, times(2)).readParameter(any());
    }
}
