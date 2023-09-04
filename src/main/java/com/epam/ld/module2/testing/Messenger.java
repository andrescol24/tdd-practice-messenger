package com.epam.ld.module2.testing;


import com.epam.ld.module2.testing.template.TextTemplate;
import com.epam.ld.module2.testing.template.TemplateEngine;

/**
 * The type Messenger.
 */
public class Messenger {
    private MailServer mailServer;

    /**
     * Instantiates a new Messenger.
     *
     * @param mailService     the mail server
     */
    public Messenger(MailServer mailService) {
        this.mailServer = mailService;
    }

    /**
     * Send message.
     *
     * @param client   the client
     * @param message the message
     */
    public void sendMessage(Client client, String message) {
        mailServer.send(client, message);
    }
}