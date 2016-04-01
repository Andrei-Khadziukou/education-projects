package com.eu.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The application to run samples of using Spring.
 *
 * @author Andrei Khadziukou
 */
public class App {

    private Client client;
    private ConsoleEventLogger consoleEventLogger;

    public App(Client client, ConsoleEventLogger consoleEventLogger) {
        this.client = client;
        this.consoleEventLogger = consoleEventLogger;
    }

    public void logEvent(String message) {
        consoleEventLogger.logEvent(message.replaceAll(client.getId(), client.getName()));
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext
            = new ClassPathXmlApplicationContext("com/eu/spring/core/spring-conf.xml");

        App app = applicationContext.getBean(App.class);
        app.logEvent("Test message from user 1");
    }
}
