package com.example.gkam4141.copypasta;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public abstract class copypastaDBFields{
    public static final String DATABASE_NAME = "myCopypastas";
    public static final String DATABASE_TABLE = "myCopypastasTable";
    public static final int DATABASE_VERSION = 2;
    public static final String KEY_ID = "_id";
    public static final String COPYPASTATEXT = "copypastaText";
    public static final String COPYPASTACATEGORY = "copypastaCategory";
}
