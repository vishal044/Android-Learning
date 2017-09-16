package com.example.vs00481543.myservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button butStart, butStop;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        butStart = (Button) findViewById(R.id.but1);
        butStop = (Button) findViewById(R.id.but2);

        butStart.setOnClickListener(this);
        butStop.setOnClickListener(this);
    }
    public void onClick(View view) {
        if (view == butStart) {
//            if(i==0) {
                startService(new Intent(this, MyIntentService.class));
                i=1;
//            }
        } else if (view == butStop) {
            stopService(new Intent(this, MyIntentService.class));
            i=0;
        }
    }


}

