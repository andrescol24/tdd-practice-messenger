package com.epam.ld.module2.testing.service;

import com.epam.ld.module2.testing.domain.Client;
import com.epam.ld.module2.testing.domain.RuntimeInformation;
import com.epam.ld.module2.testing.template.TemplateEngine;
import com.epam.ld.module2.testing.template.TextTemplate;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MessengerTest {

    @Test
    public void sendMessageTest() {
        MailServer mailServer = mock(MailServer.class);
        TextTemplate template = new TextTemplate("<h1>Welcome #{name} to our #{projectName} project</h1>");
        RuntimeInformation runtimeInformation = new RuntimeInformation();
        runtimeInformation.addValue("name", "Andrés Morales");
        runtimeInformation.addValue("projectName", "WKH-CEMS");
        Client client = new Client("andres.morales");
        ArgumentCaptor<Client> clientCaptor = ArgumentCaptor.forClass(Client.class);

        Messenger messenger = new Messenger(mailServer);
        TemplateEngine templateEngine = new TemplateEngine();
        String message = templateEngine.generateMessage(template, runtimeInformation);
        messenger.sendMessage(client, message);

        verify(mailServer).send(clientCaptor.capture(), eq("<h1>Welcome Andrés Morales to our WKH-CEMS project</h1>"));
        assertEquals("andres.morales", clientCaptor.getValue().getAddresses());
    }
}
