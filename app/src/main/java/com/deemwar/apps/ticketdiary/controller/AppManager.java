package com.deemwar.apps.ticketdiary.controller;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

import com.deemwar.apps.ticketdiary.model.Ticket;

import java.util.List;

/**
 * Created by muthuishere on 28-09-2014.
 */
public class AppManager {
    private static AppManager _instance;

    public static final String CLASS_NAME = "AppManager";
    //A Single instance to manage all tickets

    public Context appContext = null;
    public Preferences preferences;



   public List<Ticket> ticketList;

    private AppManager(Activity activity) {
        appContext = activity.getApplicationContext();

       System.out.println(appContext);
        preferences = new Preferences(appContext);

        //TODO fill up ticketlist
    }

    public static AppManager getInstance() throws Exception {
        if (_instance == null) {

            throw new Exception("Initialization error");


        }


        return _instance;
    }

    public static AppManager getInstance(Activity activity) {
        if (_instance == null && null != activity) {

            _instance = new AppManager(activity);


        }


        return _instance;
    }


}
