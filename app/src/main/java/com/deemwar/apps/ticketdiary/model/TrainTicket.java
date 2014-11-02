package com.deemwar.apps.ticketdiary.model;

import com.deemwar.apps.ticketdiary.util.Constants;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by muthuishere on 21-09-2014.
 */
public class TrainTicket extends Ticket {



    public String source;
    public String destination;

    public String trainNo;
    public String pnr;
    public String pnrstatus="";

    public Date reachTime;

    public String getStationName(){

        return source;
    }
    public String getTrainName(){

        return "";
    }
    public TrainTicket(){

        this.tktType=TicketType.TRAIN;
    }
    public static TrainTicket tryParse(String data){

        String[] tokens=data.replace("\r","").replace("\n","").split(",");


        TrainTicket ticket=new TrainTicket();
        String dateString=null;

        for(String token:tokens){
            if(token.contains("PNR"))
                ticket.pnr=token.replace("PNR","");


            if(token.contains("TRAIN"))
                ticket.trainNo=token.replace("TRAIN","");


            if(token.contains("DOJ"))
                dateString=token.replace("DOJ:","");




        }


        if(tokens.length >3)
            ticket.ticketClass=tokens[3];

        if(tokens.length >4 && tokens[4].contains("-")){

            String[] journeyDetails=tokens[4].split("-");
            ticket.source=journeyDetails[0];
            ticket.destination=journeyDetails[1];

        }


        if(tokens.length >5 && tokens[5].contains("Dep:") && null !=  dateString){

            ticket.setDateAsString(dateString + " " +tokens[5],"dd-MM-yy HH:mm");

        }

        if(tokens.length >6){

            ticket.bookedName=tokens[6];
        }



        if(null == ticket.pnr)
            ticket=null;
        else
            ticket.raw=data;

        return ticket;
    }

public String getSourceDescription(){

return source;
}

    public String getDestinationDescription(){

        return destination;

    }

    /*

  TRain detail value
      fromto  => Tirunelveli to Chennai
                  fromtodate =>                     on 26-Dec-2014 4:30 PM
                  nameno   =>Sadapthi Express(241756)
                  stationname  => Egmore Station
                  pnrno	=>3236253265
                  pnrstatus => Confirmed
                  seats => S1-S6

   */

    public String getfromto(){
        StringBuffer sb=new StringBuffer();

        sb.append(getSourceDescription()).append(" to ").append(getDestinationDescription());
        return sb.toString();

    }
    public String getNameNo(){
        StringBuffer sb=new StringBuffer();
        if(getTrainName().equals(""))
            sb.append("Train No:").append("").append(trainNo).append("");
         else
            sb.append(getTrainName()).append("(").append(trainNo).append(")");
        return sb.toString();

    }
    public String getfromtoDate(){
        StringBuffer sb=new StringBuffer();

        sb.append("                     on").append(this.getFormattedDateTime("dd-MM-yy hh:mm a"));
        return sb.toString();

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

        sb.append("Train No :").append(trainNo).append(" ").append(pnr);
        return sb.toString();
    }
}
