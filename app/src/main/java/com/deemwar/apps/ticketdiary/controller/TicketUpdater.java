package com.deemwar.apps.ticketdiary.controller;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.BaseAdapter;

import com.deemwar.apps.ticketdiary.adapters.TicketListAdapter;
import com.deemwar.apps.ticketdiary.model.SMSData;
import com.deemwar.apps.ticketdiary.model.Ticket;
import com.deemwar.apps.ticketdiary.test.Stubs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muthuishere on 28-09-2014.
 */
public class TicketUpdater extends AsyncTask<Context, Integer, List<Ticket>> {

    public static final String CLASS_NAME = "TicketUpdater";

    private TicketListAdapter adapter;

    public TicketUpdater(TicketListAdapter adapter)
    {
        this.adapter = adapter;
    }

    public static void updateTicketsFromInbox(Context context) {

        //Add code
        // List<SMSData> getAllSms()

    }

    @Override
    protected List<Ticket> doInBackground(Context... params) {
        List<Ticket> lstTickets = new ArrayList<Ticket>();
/*
        List<SMSData> lstSMSData= SMSReader.getAllSms(params[0]);

        //TODO Add Parsing here
        for(SMSData smsData:lstSMSData){

         //   if()
        }

*/
        lstTickets.add(Stubs.generateTrainTicket());
        lstTickets.add(Stubs.generateTrainTicket());
        lstTickets.add(Stubs.generateTrainTicket());
        lstTickets.add(Stubs.generateMovieTicket());
        lstTickets.add(Stubs.generateMovieTicket());


        // Ticket

        return lstTickets;
    }

    protected void onProgressUpdate(Integer... progress) {
        //    setProgressPercent(progress[0]);
    }

    protected void onPostExecute(List<Ticket> result) {

        super.onPostExecute(result);
        //dialog.dismiss();
        adapter.setTicketList(result);
        adapter.notifyDataSetChanged();


        try {
//                AppManager.getInstance().ticketList = result;
        } catch (Exception e) {
            Log.e(CLASS_NAME, e.toString());
        }
        //  showDialog("Downloaded " + result + " bytes");

    }
}
