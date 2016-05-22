package com.eu.spring.core.mms.service;

import com.eu.spring.core.mms.domain.Event;

import java.util.Date;
import java.util.List;

/**
 * The interface to define contract for interacting with {@link Event}.
 *
 * @author Andrei Khadziukou
 */
public interface EventService {

    void create(Event event);

    void remove(Event event);

    Event findByName(String name);

    List<Event> findAll();

    List<Event> findForDateRange(Date from, Date to);

    List<Event> findNExtEventsTo(Date date);



}
