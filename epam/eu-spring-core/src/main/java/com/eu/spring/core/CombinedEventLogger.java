package com.eu.spring.core;

import java.util.List;

/**
 * The combined logger to track events in different destinations.
 *
 * @author Andrei Khadziukou
 */
public class CombinedEventLogger implements EventLogger {

    List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }
    }
}
