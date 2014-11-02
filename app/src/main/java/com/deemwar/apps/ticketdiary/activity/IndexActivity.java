package com.deemwar.apps.ticketdiary.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.deemwar.apps.ticketdiary.R;
import com.deemwar.apps.ticketdiary.adapters.TicketListAdapter;
import com.deemwar.apps.ticketdiary.controller.AppManager;
import com.deemwar.apps.ticketdiary.controller.SMSReader;
import com.deemwar.apps.ticketdiary.model.BusTicket;
import com.deemwar.apps.ticketdiary.model.MovieTicket;
import com.deemwar.apps.ticketdiary.model.SMSData;
import com.deemwar.apps.ticketdiary.model.Ticket;
import com.deemwar.apps.ticketdiary.model.TrainTicket;
import com.deemwar.apps.ticketdiary.test.Stubs;

import java.util.ArrayList;
import java.util.List;


public class IndexActivity extends ActionBarActivity  implements AdapterView.OnItemClickListener {

    AppManager appManager ;
    ListView lv1;
    private TicketListAdapter adapter = null;

    public IndexActivity() {


    }
    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
        Object o = lv1.getItemAtPosition(position);
        Ticket selectedTicket = (Ticket) o;
        System.out.println("Clicked"+ selectedTicket);
        Intent intent;
        if(selectedTicket instanceof TrainTicket){
            intent= new Intent(this,TrainDetailActivity.class);
            intent.putExtra("ticket",selectedTicket);
            startActivity(intent);


        }else if(selectedTicket instanceof MovieTicket){
            intent= new Intent(this,MovieDetailActivity.class);
            intent.putExtra("ticket",selectedTicket);
            startActivity(intent);

        }else if(selectedTicket instanceof BusTicket){

            intent= new Intent(this,BusDetailActivity.class);
            intent.putExtra("ticket",selectedTicket);
            startActivity(intent);
        }

        //Toast.makeText(ListViewBlogPost.this, "You have chosen: " + " " + fullObject.getName(), Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        //ArrayList<Ticket> searchResults = appManager.ticketList;

        appManager = AppManager.getInstance(this);
         lv1 = (ListView) findViewById(R.id.listtickets);
        adapter = new TicketListAdapter(this, new ArrayList<Ticket>());

        lv1.setAdapter(adapter);

        new TicketUpdaterTask().execute();

        lv1.setOnItemClickListener(this);
    }


    protected class TicketUpdaterTask extends AsyncTask<String, Void, List<Ticket>> {

        public static final String CLASS_NAME = "TicketUpdater";


        protected void onProgressUpdate(Integer... progress) {
            //    setProgressPercent(progress[0]);
        }

        @Override
        protected List<Ticket> doInBackground(String... params) {

            List<Ticket> lstTickets = new ArrayList<Ticket>();

        List<SMSData> lstSMSData= SMSReader.getAllSms(appManager.appContext);

        //TODO Add Parsing here
        for(SMSData smsData:lstSMSData){

         //   if()
        }


            lstTickets.add(Stubs.generateTrainTicket());
            lstTickets.add(Stubs.generateTrainTicket());
            lstTickets.add(Stubs.generateTrainTicket());
            lstTickets.add(Stubs.generateMovieTicket());
            lstTickets.add(Stubs.generateMovieTicket());


            // Ticket

            return lstTickets;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.index, menu);
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
