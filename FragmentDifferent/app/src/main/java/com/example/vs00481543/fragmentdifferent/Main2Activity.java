package com.example.vs00481543.fragmentdifferent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent mIntent=getIntent();
        int pos=mIntent.getIntExtra("pos",0);
        pos+=1;

        String nam=mIntent.getStringExtra("dev");

        final TextView tex=(TextView) findViewById(R.id.text1);
        tex.setText("This is page "+pos+" and a "+nam);
    }
}
