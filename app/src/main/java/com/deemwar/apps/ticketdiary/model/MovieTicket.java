package com.deemwar.apps.ticketdiary.model;

import com.deemwar.apps.ticketdiary.util.Constants;

/**
 * Created by muthuishere on 21-09-2014.
 */
public class MovieTicket extends Ticket {
    private String name;

    private MovieTheatre theatre;

    public MovieTicket(){

        this.tktType=TicketType.MOVIE;
    }
    public static MovieTicket tryParse(String data){

        //TODO add parsing algorithm for all movie tickets
        return null;

    }

    @Override
    public String getImg() {
        return Constants.MOVIE_ICON;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public String getTagline() {
        return null;
    }
}
