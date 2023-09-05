package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.service.ConsoleReader;
import com.epam.ld.module2.testing.service.MailServer;
import com.epam.ld.module2.testing.service.Messenger;
import com.epam.ld.module2.testing.template.TemplateOutputManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleReader consoleReader = new ConsoleReader();
        MailServer mailServer = new MailServer();
        Messenger messenger = new Messenger(mailServer);
        TemplateOutputManager templateOutputManager = new TemplateOutputManager();

        TemplateApplication templateApplication = new TemplateApplication(consoleReader, messenger, templateOutputManager);
        templateApplication.run(args);
    }
}
