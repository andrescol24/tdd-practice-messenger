package com.epam.ld.module2.testing.service;

import com.epam.ld.module2.testing.domain.Client;

/**
 * Mail server class.
 */
public class MailServer {

    /**
     * Send notification.
     *
     * @param client  Client
     * @param messageContent the message content
     */
    public void send(Client client, String messageContent) {
        System.out.printf("Using a SMTP server to send the message to %s\n" +
                "============================== Mail Message ====================\n%s" +
                "\n===================================================\n", client.getAddresses(), messageContent);

    }
}
