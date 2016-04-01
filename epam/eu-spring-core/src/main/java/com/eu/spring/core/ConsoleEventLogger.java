package com.eu.spring.core;

/**
 * The logger to messages to console.
 *
 * @author Andrei Khadziukou
 */
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {
        System.out.println(event);
    }
}
