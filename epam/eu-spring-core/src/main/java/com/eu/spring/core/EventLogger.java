package com.eu.spring.core;

/**
 * The interface to log events.
 *
 * @author Andrei Khadziukou
 */
public interface EventLogger {

    /**
     * Logs the event.
     *
     * @param event the event
     */
    void logEvent(Event event);
}
