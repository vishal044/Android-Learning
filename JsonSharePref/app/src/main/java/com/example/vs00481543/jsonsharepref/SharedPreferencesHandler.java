package com.example.vs00481543.jsonsharepref;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by VS00481543 on 15-09-2017.
 */

public class SharedPreferencesHandler {

    SharedPreferences sharedPreferences;
    private Context context;
    SharedPreferences.Editor editor;

    public SharedPreferencesHandler(Context context)
    {
        this.context=context;
        sharedPreferences=context.getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void setIntPref(String key,int value)
    {
        editor.putInt(key,value);
        editor.commit();
    }

    public void setStringPref(String key,String value)
    {
        editor.putString(key,value);
        editor.commit();
    }

    public int getIntPref(String key)
    {
        return sharedPreferences.getInt(key,0);
    }


    public String getStringPref(String key)
    {
        return sharedPreferences.getString(key,"");
    }

}
