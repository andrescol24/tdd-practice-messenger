package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.domain.RuntimeInformation;
import com.epam.ld.module2.testing.service.ConsoleReader;
import com.epam.ld.module2.testing.service.Messenger;
import com.epam.ld.module2.testing.template.TemplateOutputManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class TemplateApplicationTest {
    private TemplateApplication templateApplication;
    private ConsoleReader consoleReader;
    private TemplateOutputManager templateOutputManager;
    @BeforeEach
    public void setup() {
        consoleReader = mock(ConsoleReader.class);
        Messenger messenger = mock(Messenger.class);
        templateOutputManager = mock(TemplateOutputManager.class);
        templateApplication = new TemplateApplication(consoleReader, messenger, templateOutputManager);
    }

    @Test
    public void shouldStartWith2ArgumentsTest() throws IOException {
        String[] args = new String[]{"andres@test.com", "\"<h1>Hello #{name}, this is the #{random} test</h1>\""};
        RuntimeInformation runtimeInformation = new RuntimeInformation();
        runtimeInformation.addValue("random", "Chubby");
        runtimeInformation.addValue("name", "Pepito");
        when(consoleReader.readParameters(any())).thenReturn(runtimeInformation);

        templateApplication.run(args);

        verify(consoleReader).readParameters(any());
    }

    @Test
    public void shouldStartWith3ArgumentsTest() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String inputFilePath = classLoader.getResource("template.html").getFile();
        String[] args = new String[]{"andres@test.com", inputFilePath, ""};
        RuntimeInformation runtimeInformation = new RuntimeInformation();
        runtimeInformation.addValue("projectName", "Tet");
        runtimeInformation.addValue("leaderName", "Chubby");
        runtimeInformation.addValue("name", "Pepito");
        when(consoleReader.readParameters(any())).thenReturn(runtimeInformation);

        templateApplication.run(args);

        verify(templateOutputManager).writeResult(any(), anyString());
    }

    @Test
    public void shouldNotStartWith1ArgumentsTest() throws IOException {
        String[] args = new String[]{"andres@test.com"};

        templateApplication.run(args);

        verify(consoleReader, never()).readParameters(any());
    }
}
