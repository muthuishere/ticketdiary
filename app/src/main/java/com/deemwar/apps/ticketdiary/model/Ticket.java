package com.deemwar.apps.ticketdiary.model;

import java.io.Serializable;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by muthuishere on 21-09-2014.
 */
public abstract class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
   public Date start;
    public TicketType tktType;
    public String seats="";
    public String ticketClass;
    public String bookedName;
    public String raw;

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();

        sb.append(tktType).append(" start ").append(start);
        return sb.toString();

    }

    public Date getstart(){

        return start;
    }
    public String getFormattedDateTime(String formatstr){

        String formattedVal=null;

        //26-Dec-2014 4:30 PM
        if(null != start && null != formatstr  ){



                formattedVal= new SimpleDateFormat(formatstr).format(start);
                System.out.println("formattedVal " +formattedVal);



        }
        return formattedVal;

    }
    public void setDateAsString(String dateAsString,String format){
        if(null != dateAsString && null != format  ){


            try {
                start= new SimpleDateFormat(format).parse(dateAsString);
                System.out.println("Date " +dateAsString +" set to " +start);
            } catch (ParseException e) {
                e.printStackTrace();
                start=null;
            }


        }

    }
    public String getDateOfMonth() {
        StringBuffer dateOfMonth=new StringBuffer();
        if(null != start ){

            Format formatter = new SimpleDateFormat("dd");
            dateOfMonth.append(formatter.format(start));

        }
        return dateOfMonth.toString();
    }


    public String getDayOfMonth() {


        StringBuffer dayOfMonth=new StringBuffer();
        if(null != start ){

            Format formatter = new SimpleDateFormat("EEE");
            dayOfMonth.append(formatter.format(start));

        }
        return dayOfMonth.toString();
    }
    public String getMonth() {


        StringBuffer month=new StringBuffer();
        if(null != start ){

            Format formatter = new SimpleDateFormat("MMM");
            month.append(formatter.format(start));

        }
        return month.toString();
    }

    public abstract String getImg();
    public abstract String getTitle();
    public abstract String getTagline();

}
