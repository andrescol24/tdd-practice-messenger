package com.epam.ld.module2.testing;


import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;

/**
 * The type Messenger.
 */
public class Menssager {
    private MailServer mailServer;
    private TemplateEngine templateEngine;

    /**
     * Instantiates a new Messenger.
     *
     * @param mailService     the mail server
     * @param templateEngine the template engine
     */
    public Menssager(MailServer mailService,
                     TemplateEngine templateEngine) {
        this.mailServer = mailService;
        this.templateEngine = templateEngine;
    }

    /**
     * Send message.
     *
     * @param client   the client
     * @param message the message
     */
    public void sendMessage(Client client, Template template, RuntimeInformation runtimeInformation) {
        String messageContent =
            templateEngine.generateMessage(template, runtimeInformation);
        mailServer.send(client.getAddresses(), messageContent);
    }
}