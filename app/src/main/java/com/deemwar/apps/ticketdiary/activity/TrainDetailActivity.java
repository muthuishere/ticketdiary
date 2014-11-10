package com.deemwar.apps.ticketdiary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.deemwar.apps.ticketdiary.R;
import com.deemwar.apps.ticketdiary.model.TrainTicket;

public class TrainDetailActivity extends ActionBarActivity {

    TrainTicket ticket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_detail);

        // 1. get passed intent
        Intent intent = getIntent();

        // 2. get person object from intent
        ticket = (TrainTicket) intent.getSerializableExtra("ticket");
        setDetails();
    }


    public void setDetails(){


        /*
        fromto   "Chennai to Coimbatore"
        fromtodate  "                    on 26-Dec-2014 4:30 PM"

      nameno "Sadapthi Express(241756)"
            stationname
            pnrno
            pnrstatus
            seats

         */

        TextView fromto = (TextView) findViewById(R.id.fromto);
        TextView fromtodate = (TextView) findViewById(R.id.fromtodate);
        TextView nameno = (TextView) findViewById(R.id.nameno);
        TextView stationname = (TextView) findViewById(R.id.stationname);
        TextView pnrno = (TextView) findViewById(R.id.pnrno);
        TextView pnrstatus = (TextView) findViewById(R.id.pnrstatus);
        TextView seats = (TextView) findViewById(R.id.seats);

        fromto.setText(ticket.getFromTo());
        fromtodate.setText(ticket.getFromToDate());
        nameno.setText(ticket.getNameNo());
        stationname.setText(ticket.from);
        pnrno.setText(ticket.pnr);
        pnrstatus.setText(ticket.pnrstatus);
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
