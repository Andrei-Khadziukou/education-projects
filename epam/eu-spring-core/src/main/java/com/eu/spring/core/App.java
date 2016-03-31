package com.eu.spring.core;

/**
 * Created by andrei on 31.03.2016.
 */
public class App {

    private Client client;
    private ConsoleEventLogger consoleEventLogger;

    public void logEvent(String message) {
        consoleEventLogger.logEvent(message.replaceAll(client.getId(), client.getName()));
    }

    public static void main(String[] args) {
        App app = new App();

        app.client = new Client("1", "Eduard");
        app.consoleEventLogger = new ConsoleEventLogger();

        app.logEvent("Test message from user 1");
    }
}
