package com.deemwar.apps.ticketdiary.test;

import com.deemwar.apps.ticketdiary.model.MovieTicket;
import com.deemwar.apps.ticketdiary.model.TrainTicket;

import java.util.Date;
import java.util.Random;

/**
 * Created by muthuishere on 28-09-2014.
 */
public class Stubs {

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static TrainTicket generateTrainTicket(){

        TrainTicket tk=new TrainTicket();

        tk.start=new Date() ;
        tk.pnr="PNR" + randInt(100000,999999) + "" + randInt(1000,9999);
        tk.trainNo=randInt(1000,9999) +"";
        tk.source="TEN";
        tk.destination="MS";
        return tk;
    }

    public static MovieTicket generateMovieTicket(){

        MovieTicket tk=new MovieTicket();

        String[] movies={"Murattu Kaalai","Uzhaipaali","Pollathavan","Kaali","Valli"};
        tk.start=new Date() ;
        tk.name=movies[randInt(0,4)];//+ randInt(100000,999999) + "" + randInt(1000,9999);

        tk.theatreDetails="Kasi Theatre ,Chennai";

        return tk;
    }
}
