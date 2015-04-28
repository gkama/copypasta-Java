package com.example.gkam4141.copypasta;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

/**
 * Created by gkam4141 on 4/28/2015.
 */
public class MyDBHandler extends SQLiteOpenHelper {
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, copypastaDBFields.DATABASE_NAME, factory, copypastaDBFields.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        final String DATABASE_CREATE = "CREATE TABLE " + copypastaDBFields.DATABASE_TABLE +
                "(" + copypastaDBFields.KEY_ID + " INTEGER PRIMARY KEY," +
                copypastaDBFields.COPYPASTATEXT + " TEXT," +
                copypastaDBFields.COPYPASTACATEGORY + " TEXT)";
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //db.execSQL("DROP TABLE IF EXISTS " + copypastaDBFields.DATABASE_TABLE);
        //onCreate(db);
    }

    // add copy pasta text
    public void addCopypastaText(copypastaText product){
        ContentValues values = new ContentValues();
        values.put(copypastaDBFields.COPYPASTATEXT, product.getCopypastaText());
        values.put(copypastaDBFields.COPYPASTACATEGORY, product.getCopypastaTextCategory());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(copypastaDBFields.DATABASE_TABLE, null, values);
        db.close();
    }

    // Find copypasta text
    public copypastaText findCopypastaText(String textName){
        String query = "Select * FROM " + copypastaDBFields.DATABASE_TABLE + " WHERE " + copypastaDBFields.COPYPASTATEXT + " = \"" + textName + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        copypastaText text = new copypastaText();

        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            text.setCopypastaText(cursor.getString(0));
            text.setCopypastaTextCategory(cursor.getString(1));
            cursor.close();
        } else {
            text = null;
        }
        db.close();
        return text;
    }

    // delete copy pasta text
    public boolean deleteText(String textName){
        boolean result = false;
        String query = "Select * FROM " + copypastaDBFields.DATABASE_TABLE + " WHERE " + copypastaDBFields.COPYPASTATEXT + " = \"" + textName + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        copypastaText text = new copypastaText();

        if(cursor.moveToFirst()){
            text.setCopypastaText(cursor.getString(0));
            db.delete(copypastaDBFields.DATABASE_TABLE, copypastaDBFields.KEY_ID + " = ?", new String[] {String.valueOf(text.getCopypastaText())});
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    // get DB count
    public Cursor fetchCopyPastas(){
        //SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + copypastaDBFields.DATABASE_TABLE, null);
        return cursor;
    }
}
