package com.epam.ld.module2.testing;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

public class TemplateApplicationTest {

    @Spy
    private TemplateApplication templateService;

    @Test
    public void printMessageTest() {
        Messenger messenger = mock(Messenger.class);
        templateService = spy(new TemplateApplication());
    }
}
