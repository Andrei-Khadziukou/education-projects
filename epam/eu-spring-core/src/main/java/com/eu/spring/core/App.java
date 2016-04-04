package com.eu.spring.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * The application to run samples of using Spring.
 *
 * @author Andrei Khadziukou
 */
public class App implements ApplicationContextAware {

    private Client client;
    private EventLogger defaultEventLogger;
    private ApplicationContext applicationContext;
    private Map<EventType, EventLogger> typeToLoggerMap;

    public App(Client client, Map<EventType, EventLogger> typeToLoggerMap) {
        this.client = client;
        this.typeToLoggerMap = typeToLoggerMap;
    }

    public void logEvent(String message, EventType type) {
        Event event = applicationContext.getBean(Event.class);
        event.setMessage(message.replaceAll(client.getId(), client.getName()));
        EventLogger logger = typeToLoggerMap.get(type);
        if (type == null) {
            defaultEventLogger.logEvent(event);
        } else {
            logger.logEvent(event);
        }
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext
            = new ClassPathXmlApplicationContext("com/eu/spring/core/spring-conf.xml");

        App app = applicationContext.getBean(App.class);
        app.logEvent("Test message from user 1", null);
        app.logEvent("Test message 2 from user 1", EventType.INFO);
        app.logEvent("Test message 3 from user 1", EventType.ERROR);
        applicationContext.close();
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void setDefaultEventLogger(EventLogger defaultEventLogger) {
        this.defaultEventLogger = defaultEventLogger;
    }
}
