package com.deemwar.apps.ticketdiary.test;

import com.deemwar.apps.ticketdiary.model.BusTicket;
import com.deemwar.apps.ticketdiary.model.MovieTicket;
import com.deemwar.apps.ticketdiary.model.TrainTicket;

import java.util.Calendar;
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

    public static Date generateRandomDate(){

        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        c.add(Calendar.DATE, randInt(0,14));
        return c.getTime();
    }
    public static BusTicket generateBusTicket(){

        BusTicket tk=new BusTicket();

        String[] fromstations={"Chennai","Coimbatore","Hyderabad","Bangalore","Trivandrum"};
        String[] tostations={"Tirunelveli","Kanyakumari","Madurai","Trichy","Vilupuram"};
        String[] travelslist={"Parveen TRavels","SRM Travels","SD Buses","TNSTC transport","KPN Travels"};
        tk.start=generateRandomDate() ;


        tk.start=generateRandomDate() ;
        String from=fromstations[randInt(0,4)];
        String to=tostations[randInt(0,4)];

        tk.travelsName=travelslist[randInt(0,4)];
        tk.boardingPoint=" Gandi Nagar," + from;

        tk.from=from;
        tk.to=to;


        return tk;
    }
    public static TrainTicket generateTrainTicket(){

        TrainTicket tk=new TrainTicket();

        String[] fromstations={"Chennai","Delhi","Mumbai","Bangalore","Kolkatta"};
        String[] tostations={"Tirunelveli","Kanyakumari","Madurai","Trichy","Vilupuram"};



       // Sadapthi Express
        tk.start=generateRandomDate() ;
        tk.pnr="PNR" + randInt(100000,999999) + "" + randInt(1000,9999);
        tk.trainNo=randInt(1000,9999) +"";

        String from=fromstations[randInt(0,4)];
        String to=tostations[randInt(0,4)];
        tk.trainName=to + " Express";
        tk.sourcecode=from.substring(0,2);
        tk.destinationcode=to.substring(0,2);
        tk.updateTravelStations();
        tk.from=from;
        tk.to=to;

        String[] seatlist={"K1-K12","L2-L4","J1-J4","A1","B2-B7"};

        String[] statuslist={"WL 123","Confirmed","RAC 4"};
       String pnrstatus=statuslist[randInt(0,2)];

        tk.pnrstatus=pnrstatus;

        if("Confirmed".equals(pnrstatus))
            tk.seats=seatlist[randInt(0,4)];
        else
            tk.seats="-";


        return tk;
    }

    public static MovieTicket generateMovieTicket(){

        MovieTicket tk=new MovieTicket();

        String[] movies={"Murattu Kaalai","Uzhaipaali","Pollathavan","Kaali","Valli"};
        String[] seatlist={"K1-K12","L2-L4","J1-J4","A1","B2-B7"};
        String[] theatres={"Kasi Theatre ,Chennai","Albert-Chennai","Satyam Cinemas","Sangam","Devi Cinema"};
        tk.start=generateRandomDate() ;
        tk.movieName=movies[randInt(0,4)];//+ randInt(100000,999999) + "" + randInt(1000,9999);
tk.seats=seatlist[randInt(0,4)];
        tk.theatreDetails=theatres[randInt(0,4)];

        return tk;
    }
}
