package com.deemwar.apps.ticketdiary.model;

import com.deemwar.apps.ticketdiary.util.Constants;

/**
 * Created by muthuishere on 21-09-2014.
 */
public class BusTicket extends Ticket {
    public String name;


  //  private MovieTheatre theatre;
    public String theatreDetails;

    public BusTicket(){

        this.tktType=TicketType.MOVIE;
    }
    public static BusTicket tryParse(String data){


/*
        MovieTicket ticket=new MovieTicket();

        String[] tokens=data.replace("\r","").replace("\n","").split(",");

        Map<String,String> result=new HashMap<String,String>();


        for(String token:tokens){
            if(token.contains("PNR"))
               // ticket.
                result.put("PNR",token);

            if(token.contains("TRAIN"))
                result.put("TRAIN",token);

            if(token.contains("DOJ"))
                result.put("DOJ",token);

        }
*/
        //TODO add parsing algorithm for all movie tickets
        return null;

    }

    @Override
    public String getImg() {
        return Constants.BUS_ICON;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public String getTagline() {
        return theatreDetails;
    }
}
