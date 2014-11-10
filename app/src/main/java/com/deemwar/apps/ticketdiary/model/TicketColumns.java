package com.deemwar.apps.ticketdiary.model;

import android.provider.BaseColumns;

import java.sql.Date;

/**
 * Created by muthuishere on 29-09-2014.
 */
public class TicketColumns implements BaseColumns {
    // This class cannot be instantiated
    private TicketColumns() {}

    /*

     db.execSQL("CREATE TABLE tickets ("
                    + "_id INTEGER PRIMARY KEY,"
                    + "date DATE,"
                    + "ticketno TEXT,tickettype TEXT,raw TEXT"


     */
    public static final String TABLENAME = "tickets";


    public static final String DATE = "date";

    public static final String TICKET_NO = "ticketno";
    public static final String TICKET_TYPE = "tickettype";
    public static final String RAW = "raw";



}
