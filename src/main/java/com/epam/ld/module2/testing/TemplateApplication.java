package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.domain.Client;
import com.epam.ld.module2.testing.domain.RuntimeInformation;
import com.epam.ld.module2.testing.service.ConsoleReader;
import com.epam.ld.module2.testing.service.Messenger;
import com.epam.ld.module2.testing.template.FileTemplate;
import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;
import com.epam.ld.module2.testing.template.TextTemplate;

import java.io.File;
import java.io.IOException;

public class TemplateApplication {
    private final ConsoleReader consoleReader;
    private final Messenger messenger;
    public TemplateApplication(ConsoleReader consoleReader, Messenger messenger) {
        this.consoleReader = consoleReader;
        this.messenger = messenger;
    }

    public void run(String[] args) throws IOException {
        if(args.length != 2 && args.length != 3) {
            System.out.println("Wrong arguments." +
                    "\nConsole mode: <client addresses> <template as string>" +
                    "\nFile Mode: <client addresses> <template file path> <output file path>");
            return;
        }

        Template template;
        Client client = new Client(args[0]);
        if(args.length == 2) { // Console mode
            template = new TextTemplate(args[1]);
        } else { // File mode
            File file = new File(args[1]);
            if(!file.exists()) {
                System.out.printf("Please verify template input file, wrong path: %s", args[1]);
                return;
            }
            template = new FileTemplate(args[1], args[2]);
        }

        String message = this.readRuntimeInformationAndGetMessage(template);
        messenger.sendMessage(client, message);
    }

    private String readRuntimeInformationAndGetMessage(Template template) {
        RuntimeInformation runtimeInformation = consoleReader.readParameters(template.getParameterNames());
        TemplateEngine templateEngine = new TemplateEngine();
        return templateEngine.generateMessage(template, runtimeInformation);
    }
}
