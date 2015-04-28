package com.example.gkam4141.copypasta;

import android.app.ActionBar;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class copypastaActivity extends ActionBarActivity {

    public final String KrippCategory = "Kripp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copypasta);

        // add view
        LinearLayout copypastaMainView = (LinearLayout) findViewById(R.id.copypastaMainView);
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        copypastaText copypastatext = new copypastaText();


        dbHandler.addCopypastaText(new copypastaText("ᴋʀɪᴘᴘ, ᴛʜɪs ɪs ᴛʜᴇ ᴍᴀʏᴏʀ ᴏғ ᴄᴀɴᴀᴅᴀʟᴀɴᴅ. ᴡᴇ ɴᴇᴇᴅ ʏᴏᴜ ʜᴏᴍᴇ ᴍʏ sᴏɴ, ᴇᴠᴇʀ sɪɴᴄᴇ ʏᴏᴜ ʟᴇғᴛ ᴜs ᴏᴜʀ sᴀʟᴛ ᴍɪɴᴇs ʜᴀᴠᴇ ʙᴇᴇɴ ʀᴜɴɴɪɴɢ ᴅʀʏ. ɴᴏ ᴏɴᴇ ɪs ᴘʀᴏᴠɪᴅɪɴɢ ᴛʜᴇsᴇ ᴘᴏᴏʀ ʜᴀʀᴅ-ᴡᴏʀᴋɪɴɢ ᴘᴇᴏᴘʟᴇ ᴡɪᴛʜ ᴛʜᴇ ᴛᴀʙʟᴇ sᴀʟᴛ ᴛʜᴇʏ ᴅᴇsᴇʀᴠᴇ ғᴏʀ ᴛʜᴇɪʀ ᴅᴀɪʟʏ ᴍᴇᴀʟs. ᴡᴇ ɴᴇᴇᴅ ʏᴏᴜ ᴏᴄᴛᴀᴠɪᴀɴ.", KrippCategory));
        dbHandler.addCopypastaText(new copypastaText("SASK", "ASD"));
        dbHandler.addCopypastaText(new copypastaText("123", "123"));


        Cursor c = dbHandler.fetchCopyPastas();
        if(c.moveToFirst()){
            do{
                String text = c.getString(1);
                String category = c.getString(2);

                TextView textView = new TextView(this);
                textView.setPadding(0, 0, 0, 40);
                ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                textView.setLayoutParams(lp);
                textView.setText("Category: " + category + "\n" + text + "\n");
                
                copypastaMainView.addView(textView);
            } while (c.moveToNext());
        }
        c.close();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_copypasta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
