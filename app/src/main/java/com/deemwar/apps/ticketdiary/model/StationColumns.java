package com.deemwar.apps.ticketdiary.model;

import android.provider.BaseColumns;

/**
 * Created by muthuishere on 29-09-2014.
 */
public class StationColumns implements BaseColumns {
    // This class cannot be instantiated
    private StationColumns () {}

    /**
     * The table name of animals = "animals"
     */
    public static final String TABLENAME = "stations";

    /**
     * The title of the animal
     * <P>Type: TEXT</P>
     */
    public static final String CODE = "code";

    /**
     * The color of the animal
     * <P>Type: TEXT</P>
     */
    public static final String NAME = "name";


}
