package com.epam.ld.module2.testing.service;


import com.epam.ld.module2.testing.domain.Client;

/**
 * The type Messenger.
 */
public class Messenger {
    private final MailServer mailServer;

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