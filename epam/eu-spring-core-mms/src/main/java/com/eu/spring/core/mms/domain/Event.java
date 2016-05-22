package com.eu.spring.core.mms.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * The system entity to represent different events.
 *
 * @author Andrei Khadziukou
 */
public class Event {

    private String id;
    private String title;
    private double bestTicketPrice;
    private EventRating rating;
    private Date[] dates;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getBestTicketPrice() {
        return bestTicketPrice;
    }

    public void setBestTicketPrice(double bestTicketPrice) {
        this.bestTicketPrice = bestTicketPrice;
    }

    public EventRating getRating() {
        return rating;
    }

    public void setRating(EventRating rating) {
        this.rating = rating;
    }

    public Date[] getDates() {
        return dates;
    }

    public void setDates(Date[] dates) {
        this.dates = dates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        return new EqualsBuilder()
                .append(bestTicketPrice, event.bestTicketPrice)
                .append(id, event.id)
                .append(title, event.title)
                .append(rating, event.rating)
                .append(dates, event.dates)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(title)
                .append(bestTicketPrice)
                .append(rating)
                .append(dates)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("title", title)
                .append("bestTicketPrice", bestTicketPrice)
                .append("rating", rating)
                .append("dates", dates)
                .toString();
    }
}
