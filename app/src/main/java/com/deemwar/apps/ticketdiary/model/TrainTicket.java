package com.deemwar.apps.ticketdiary.model;

import java.util.Date;

/**
 * Created by muthuishere on 21-09-2014.
 */
public class TrainTicket extends Ticket {

    private String from;
    private String to;
    private String trainNo;
    private String fromcode;
    private String tocode;
    private Date reachTime;


    public Date getReachTime() {
        return reachTime;
    }

    public void setReachTime(Date reachTime) {
        this.reachTime = reachTime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public String getFromcode() {
        return fromcode;
    }

    public void setFromcode(String fromcode) {
        this.fromcode = fromcode;
    }

    public String getTocode() {
        return tocode;
    }

    public void setTocode(String tocode) {
        this.tocode = tocode;
    }
}
