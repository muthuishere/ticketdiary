package com.deemwar.apps.ticketdiary.controller;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.deemwar.apps.ticketdiary.R;
import com.deemwar.apps.ticketdiary.model.StationColumns;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by muthuishere on 28-09-2014.
 */
public class DbAdapter {


    // database details
    private static final String DATABASE_NAME = "ticketdiary";
    private static final int DATABASE_VERSION = 1;

    // where we're running
    private final Context mCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private final Context fContext;

        static final String TAG = "DatabaseHelper";

        DatabaseHelper(Context context) {

            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            fContext = context;
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE stations ("
                    + "_id INTEGER PRIMARY KEY,"
                    + "code TEXT,"
                    + "name TEXT"
                    + ");");

            //Add default records to animals
            ContentValues _Values = new ContentValues();
            //Get xml resource file
            Resources res = fContext.getResources();

            //Open xml file
            XmlResourceParser _xml = res.getXml(R.xml.stations);
            try {
                //Check for end of document
                int eventType = _xml.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    //Search for record tags
                    if ((eventType == XmlPullParser.START_TAG) && (_xml.getName().equals("station"))) {
                        //Record tag found, now get values and insert record
                        String _Code = _xml.getAttributeValue(null, StationColumns.CODE);
                        String _Name = _xml.getAttributeValue(null, StationColumns.NAME);
                        _Values.put(StationColumns.CODE, _Code);
                        _Values.put(StationColumns.NAME, _Name);
                        db.insert(StationColumns.TABLENAME, null, _Values);
                    }
                    eventType = _xml.next();
                }
            }
            //Catch errors
            catch (XmlPullParserException e) {
                Log.e(TAG, e.getMessage(), e);
            } catch (IOException e) {
                Log.e(TAG, e.getMessage(), e);

            } finally {
                //Close the xml file
                _xml.close();
            }
        }

        /* Update database to latest version */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //Crude update, make sure to implement a correct one when needed.

            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS animals");
            onCreate(db);
        }
    }

    public DbAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    public DbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    // other database methods can go here
}