package com.deemwar.apps.ticketdiary.model;

/**
 * Created by muthuishere on 21-09-2014.
 */
public enum TicketType {
    MOVIE("Movie", 0),
    TRAIN("Train", 1),
    BUS("Bus", 2),
    FLIGHT("Flight", 3);

    private String stringValue;
    private int intValue;
    private TicketType(String toString, int value) {
        stringValue = toString;
        intValue = value;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
