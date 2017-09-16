package com.example.vs00481543.myboundservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    MyLocalService localService;
    private boolean isBound=false;

    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalService.localBinder binder=(MyLocalService.localBinder) service;
            localService = binder.getService();
            isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStart()
    {
        super.onStart();
        Intent intent=new Intent(this,MyLocalService.class);
        bindService(intent,connection, Context.BIND_AUTO_CREATE);
    }

    protected void onStop()
    {
        super.onStop();
        if(isBound)
        {
            unbindService(connection);
            isBound=false;
        }
    }


    public void displayDate(View view)
    {
        if(isBound)
        {
            Date date=localService.getCurrentDate();
            Toast.makeText(this,String.valueOf(date),Toast.LENGTH_SHORT).show();
        }
    }
}
