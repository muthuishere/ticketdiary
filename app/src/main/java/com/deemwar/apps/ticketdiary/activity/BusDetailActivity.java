package com.deemwar.apps.ticketdiary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.deemwar.apps.ticketdiary.R;
import com.deemwar.apps.ticketdiary.model.BusTicket;

public class BusDetailActivity extends ActionBarActivity {

    BusTicket ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_detail);

        // 1. get passed intent
        Intent intent = getIntent();

        // 2. get person object from intent
        ticket = (BusTicket) intent.getSerializableExtra("ticket");
        setDetails();
        //System.out.println(ticket);

    }

    public void setDetails(){


        /*
        fromto   "Chennai to Coimbatore"
        fromtodate  "                    on 26-Dec-2014 4:30 PM"
          busagency
            stationname
            seats
         */

        TextView fromto = (TextView) findViewById(R.id.fromto);
        TextView fromtodate = (TextView) findViewById(R.id.fromtodate);
        TextView busagency = (TextView) findViewById(R.id.busagency);
        TextView stationname = (TextView) findViewById(R.id.stationname);
        TextView seats = (TextView) findViewById(R.id.seats);

        fromto.setText(ticket.getFromTo());
        fromtodate.setText(ticket.getFromToDate());
        busagency.setText(ticket.travelsName);
        stationname.setText(ticket.boardingPoint);
        seats.setText(ticket.seats);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
