package com.deemwar.apps.ticketdiary.model;

import com.deemwar.apps.ticketdiary.util.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by muthuishere on 21-09-2014.
 */
public class MovieTicket extends Ticket {
    public String movieName;


  //  private MovieTheatre theatre;
    public String theatreDetails;

    public MovieTicket(){

        this.tktType=TicketType.MOVIE;
    }
    public static MovieTicket tryParse(String data){


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

    public String getMovieDate(){
        StringBuffer sb=new StringBuffer();

        sb.append("                     on").append(this.getFormattedDateTime("dd-MM-yy hh:mm a"));
        return sb.toString();

    }
    @Override
    public String getImg() {
        return Constants.MOVIE_ICON;
    }

    @Override
    public String getTitle() {
        return movieName;
    }

    @Override
    public String getTagline() {
        return theatreDetails;
    }
}
