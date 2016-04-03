package com.eu.spring.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The application to run samples of using Spring.
 *
 * @author Andrei Khadziukou
 */
public class App implements ApplicationContextAware {

    private Client client;
    private ConsoleEventLogger consoleEventLogger;
    private ApplicationContext applicationContext;

    public App(Client client, ConsoleEventLogger consoleEventLogger) {
        this.client = client;
        this.consoleEventLogger = consoleEventLogger;
    }

    public void logEvent(String message) {
        Event event = applicationContext.getBean(Event.class);
        event.setMessage(message.replaceAll(client.getId(), client.getName()));
        consoleEventLogger.logEvent(event);
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext
            = new ClassPathXmlApplicationContext("com/eu/spring/core/spring-conf.xml");

        App app = applicationContext.getBean(App.class);
        app.logEvent("Test message from user 1");
        applicationContext.close();
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
