package com.example.gkam4141.copypasta;

import android.widget.LinearLayout;

/**
 * Created by gkam4141 on 4/28/2015.
 */
public class copypastaText {
    private String copypastaText;
    private String copypastaTextCategory;
    public static int textCounter = 0;

    public copypastaText(){}

    public copypastaText(String thiscopypastaText, String thiscopypastaTextCategory){
        textCounter += 1;
        this.copypastaText = thiscopypastaText;
        this.copypastaTextCategory = thiscopypastaTextCategory;
    }

    public void setCopypastaText(String thiscopypastaText){
        this.copypastaText = thiscopypastaText;
    }

    public String getCopypastaText (){
        return this.copypastaText;
    }

    public void setCopypastaTextCategory(String thiscopypastaTextCategory){
        this.copypastaTextCategory = thiscopypastaTextCategory;
    }

    public String getCopypastaTextCategory (){
        return this.copypastaTextCategory;
    }

    public void clear(){
        this.copypastaText = null;
        this.copypastaTextCategory = null;
    }
}
