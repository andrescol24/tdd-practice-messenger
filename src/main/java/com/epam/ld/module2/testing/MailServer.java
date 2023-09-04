package com.epam.ld.module2.testing;

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
        System.out.println("Using a SMTP server to send the message...");
        System.out.println(messageContent);
    }
}
