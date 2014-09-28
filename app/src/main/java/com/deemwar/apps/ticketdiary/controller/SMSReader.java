package com.deemwar.apps.ticketdiary.controller;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony.Sms;
import android.util.Log;

import com.deemwar.apps.ticketdiary.model.SMSData;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by muthuishere on 28-09-2014.
 */
public class SMSReader {

    public static final String CLASS_NAME = "SMSReader";

    public static List<SMSData> getAllSms(Context context) {

        List<SMSData> smsList = new ArrayList<SMSData>();
        Cursor c = null;
        try {
            Uri uri = Uri.parse("content://sms/inbox");
            c = context.getContentResolver().query(uri, null, null, null, null);
            //     startManagingCursor(c);

            // Read the sms data and store it in the list
            if (c.moveToFirst()) {
                for (int i = 0; i < c.getCount(); i++) {
                    SMSData sms = new SMSData();
                    sms.body = c.getString(c.getColumnIndexOrThrow("body")).toString();
                    sms.number = c.getString(c.getColumnIndexOrThrow("address")).toString();
                    smsList.add(sms);

                    c.moveToNext();
                }
            }
        } catch (Exception e) {

            Log.e(CLASS_NAME, "Exception while reading sms " + e.getMessage());
        } finally {

            if (null != c && c.isClosed() == false) {

                c.close();
            }

        }


        return smsList;

    }
}
