package com.eu.spring.core;

import java.util.ArrayList;
import java.util.List;

/**
 * The cached implementation of event logger.
 *
 * @author Andrei Khadziukou
 */
public class CacheEventLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> events;

    public CacheEventLogger(int cacheSize, String fileName) {
        super(fileName);
        this.cacheSize = cacheSize;
        events = new ArrayList<>(cacheSize);
    }

    public void logEvent(Event event) {
        events.add(event);

        if (cacheSize == events.size()) {
            writeEventsFromCache();
            events.clear();
        }

    }

    private void destroy() {
        if (!events.isEmpty()) {
            writeEventsFromCache();
        }
    }

    private void writeEventsFromCache() {
        for (Event event : events) {
            super.logEvent(event);
        }
    }
}
