package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TextTemplate;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class ConsoleReaderTest {
    @Test
    public void testReadParameters() {
        Template template = new TextTemplate("<h1>Hello #{name}, this is a greating from #{team} team</h1>");
        ConsoleReader consoleReader = spy(new ConsoleReader());
        doReturn("Andres").when(consoleReader).readParameter(eq("name"));
        doReturn("WKH-CEMS").when(consoleReader).readParameter(eq("team"));

        Map<String, String> parameters = consoleReader.readParameters(template.getParameterNames());

        assertEquals("Andres", parameters.get("name"));
        assertEquals("WKH-CEMS", parameters.get("team"));
        verify(consoleReader, times(2)).readParameter(any());
    }
}
