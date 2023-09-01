package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MessengerTest {
    @Test
    public void sendMessageTest() {
        MailServer mailServer = mock(MailServer.class);
        Template template = new Template("<h1>Welcome #{name} to our #{projectName} project</h1>");
        RuntimeInformation runtimeInformation = new RuntimeInformation();
        runtimeInformation.addValue("name", "Andrés Morales");
        runtimeInformation.addValue("projectName", "WKH-CEMS");
        Client client = new Client();
        client.setAddresses("andres.morales");

        Menssager messenger = new Menssager(mailServer, new TemplateEngine());
        messenger.sendMessage(client, template, runtimeInformation);

        verify(mailServer).send(any(), eq("<h1>Welcome Andrés Morales to our WKH-CEMS project</h1>"));

    }
}
