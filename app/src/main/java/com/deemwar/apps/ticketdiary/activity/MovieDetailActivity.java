package com.deemwar.apps.ticketdiary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.deemwar.apps.ticketdiary.R;
import com.deemwar.apps.ticketdiary.model.MovieTicket;

public class MovieDetailActivity extends ActionBarActivity {

    MovieTicket ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);


        // 1. get passed intent
        Intent intent = getIntent();

        // 2. get person object from intent
        ticket = (MovieTicket) intent.getSerializableExtra("ticket");

        System.out.println(ticket);
    }

    public void setDetails(){


        /*


             moviename
            moviedate "                    on 26-Dec-2014 4:30 PM"
            theatre
            seats
         */

        TextView moviename = (TextView) findViewById(R.id.moviename);
        TextView moviedate = (TextView) findViewById(R.id.moviedate);
        TextView theatre = (TextView) findViewById(R.id.theatre);

        TextView seats = (TextView) findViewById(R.id.seats);

        moviename.setText(ticket.movieName);
        moviedate.setText(ticket.getMovieDate());
        theatre.setText(ticket.theatreDetails);

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
