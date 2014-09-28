package com.deemwar.apps.ticketdiary.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

/**
 * Created by muthuishere on 28-09-2014.
 */
public class Preferences {
    SharedPreferences prefs;
    SharedPreferences.Editor prefsEditor;
    private boolean useAsyncCommit;

    public Preferences(Context context) {

        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefsEditor = prefs.edit();

        //Indicator whether or not the apply() method is available in the current API Version
        useAsyncCommit = Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
    }


    public boolean getBoolean(String key, boolean defValue) {
        return prefs.getBoolean(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return prefs.getInt(key, defValue);
    }

    public String getString(String key, String defValue) {
        return prefs.getString(key, defValue);
    }

    public String getString(String key) {
        return prefs.getString(key, "");
    }

    public void putBoolean(String key, boolean value) {
        prefsEditor.putBoolean(key, value);
    }

    public void putInt(String key, int value) {
        prefsEditor.putInt(key, value);
    }

    public void putString(String key, String value) {
        prefsEditor.putString(key, value);
    }

    /**
     * Sincle API Level 9, apply() has been provided for asynchronous operations.
     * If not available, fallback to the synchronous commit()
     */
    public void commit() {
        if (useAsyncCommit)
            //Since API Level 9, apply() is provided for asynchronous operations
            prefsEditor.apply();
        else
            //Fallback to syncrhonous if not available
            prefsEditor.commit();
    }
}
