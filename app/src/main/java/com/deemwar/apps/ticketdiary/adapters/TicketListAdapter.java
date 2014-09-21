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
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
public class TicketListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Ticket> ticketList;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public TicketListAdapter(Activity activity, List<Ticket> ticketList) {
        this.activity = activity;
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
            convertView = inflater.inflate(R.layout.ticketrow, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView rating = (TextView) convertView.findViewById(R.id.rating);
        TextView genre = (TextView) convertView.findViewById(R.id.genre);
        TextView year = (TextView) convertView.findViewById(R.id.releaseYear);


        // getting movie data for the row
        Ticket m = ticketList.get(position);
/*
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
