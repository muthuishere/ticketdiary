package com.deemwar.apps.ticketdiary.model;

import com.deemwar.apps.ticketdiary.util.Constants;

import java.util.Date;

/**
 * Created by muthuishere on 21-09-2014.
 */
public class TrainTicket extends Ticket {

    public String source;
    public String destination;
    public String trainNo;
    public String pnr;

    public Date reachTime;


    public TrainTicket(){

        this.tktType=TicketType.TRAIN;
    }
    public static TrainTicket tryParse(String data){

        //TODO add parsing algorithm for all Train tickets

        return null;
    }

public String getSourceDescription(){

return source;
}

    public String getDestinationDescription(){

        return destination;

    }

    @Override
    public String getImg() {
        return Constants.TRAIN_ICON;
    }

    @Override
    public String getTitle() {
        StringBuffer sb=new StringBuffer();

        sb.append(getSourceDescription()).append(" to ").append(getDestinationDescription());
        return sb.toString();
    }

    @Override
    public String getTagline() {
        StringBuffer sb=new StringBuffer();

        sb.append("Train No :").append(trainNo).append(" PNR").append(pnr);
        return sb.toString();
    }
}
