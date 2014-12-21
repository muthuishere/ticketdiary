package com.deemwar.apps.ticketdiary.adapters;


/**
 * Created by muthuishere on 21-09-2014.
 */

import com.deemwar.apps.ticketdiary.R;
import com.deemwar.apps.ticketdiary.controller.AppController;
import com.deemwar.apps.ticketdiary.model.Ticket;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.deemwar.apps.ticketdiary.model.TrainTicket;

public class TicketListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;



    private List<Ticket> ticketList;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public TicketListAdapter(Activity activity, List<Ticket> ticketList) {
        this.activity = activity;
        this.ticketList = ticketList;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }
    public void setTicketList(List<Ticket> ticketList) {

        this.ticketList = ticketList;
    }
    @Override
    public int getCount() {
        return ticketList.size();
    }

    @Override
    public Object getItem(int location) {
        return ticketList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {




        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.genericticketrow, null);

      //  if (imageLoader == null)
        //    imageLoader = AppController.getInstance().getImageLoader();
      //  NetworkImageView thumbNail = (NetworkImageView) convertView
             //   .findViewById(R.id.thumbnail);


        //set font as Tahoma for
        // 2 digit android:paddingLeft="15sp"
        //1 digit android:paddingLeft="22sp"

        TextView month = (TextView) convertView.findViewById(R.id.month);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView day = (TextView) convertView.findViewById(R.id.day);



        TextView title = (TextView) convertView.findViewById(R.id.title);


        TextView tagline = (TextView) convertView.findViewById(R.id.tagline);

        ImageView tickettypeimg=(ImageView) convertView.findViewById(R.id.tickettypeimg);

        if(null != ticketList && ticketList.size() > position){
        // getting movie data for the row
        Ticket ticket = ticketList.get(position);
        title.setText(ticket.getTitle());
        month.setText(ticket.getMonth());
        date.setText(ticket.getDateOfMonth());

        day.setText(ticket.getDayOfMonth());
        tagline.setText(ticket.getTagline());

        if(ticket instanceof TrainTicket)
            tickettypeimg.setImageResource(R.drawable.train);
        else
            tickettypeimg.setImageResource(R.drawable.movie);

        }
/*




    <ImageView
        android:id="@+id/tickettypeimg"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentRight="true"
        android:textColor="@color/year"
        android:textSize="@dimen/year"
        android:text="PNR 24565787"
        android:src="@drawable/train" />

        // thumbnail image
        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

        // title
        title.setText(m.getTitle());

        // rating
        rating.setText("Rating: " + String.valueOf(m.getRating()));

        // genre
        String genreStr = "";
        for (String str : m.getGenre()) {
            genreStr += str + ", ";
        }
        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
                genreStr.length() - 2) : genreStr;
        genre.setText(genreStr);

        // release year
        year.setText(String.valueOf(m.getYear()));
*/
        return convertView;
    }

}
