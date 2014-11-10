package com.deemwar.apps.ticketdiary.model;

/**
 * Created by muthuishere on 09-11-2014.
 */
public abstract class TravelTicket extends Ticket{
    public String from;
    public String to;

    public void setFromTo(String from ,String to){

        this.from=from;
        this.to=to;
    }

    public String getFromTo(){
        StringBuffer sb=new StringBuffer();

        sb.append(from).append(" to ").append(to);
        return sb.toString();

    }

    public String getFromToDate(){
        StringBuffer sb=new StringBuffer();

        sb.append("                     on").append(this.getFormattedDateTime("dd-MM-yy hh:mm a"));
        return sb.toString();

    }
}
