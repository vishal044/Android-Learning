package com.example.vs00481543.jsonsharepref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    SharedPreferencesHandler sharedPreferencesHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView=(TextView) findViewById(R.id.text1);


        sharedPreferencesHandler=new SharedPreferencesHandler(Main2Activity.this);
        int size=sharedPreferencesHandler.getIntPref("numOfContacts");
        String name1=sharedPreferencesHandler.getStringPref("myName");

        Intent intent=getIntent();
        int pos=intent.getIntExtra("position",0);
        pos+=1;
        String name=intent.getStringExtra("name");

        textView.setText(name+" is at position "+pos+" where total comntacts are "+size+" and my name is "+name1);
    }
}
