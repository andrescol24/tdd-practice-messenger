package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.service.ConsoleReader;
import com.epam.ld.module2.testing.service.Messenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class TemplateApplicationTest {
    private TemplateApplication templateApplication;
    private ConsoleReader consoleReader;

    @BeforeEach
    public void setup() {
        consoleReader = mock(ConsoleReader.class);
        Messenger messenger = mock(Messenger.class);
        templateApplication = new TemplateApplication(consoleReader, messenger);
    }

    @Test
    public void shouldStartWith2ArgumentsTest() throws IOException {
        String[] args = new String[]{"andres@test.com", "\"<h1>Hello #{name}, this is the #{random} test</h1>\""};

        templateApplication.run(args);

        verify(consoleReader).readParameters(any());
    }

    @Test
    public void shouldStartWith3ArgumentsTest() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String inputFilePath = classLoader.getResource("template.html").getFile();
        String[] args = new String[]{"andres@test.com", inputFilePath, ""};

        templateApplication.run(args);

        verify(consoleReader).readParameters(any());
    }

    @Test
    public void shouldNotStartWith1ArgumentsTest() throws IOException {
        String[] args = new String[]{"andres@test.com"};

        templateApplication.run(args);

        verify(consoleReader, never()).readParameters(any());
    }
}
