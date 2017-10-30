package com.example.vs00481543.phonecallrecorder;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(checkPermission())
            Toast.makeText(getApplicationContext(),"Permission already granted",Toast.LENGTH_LONG).show();
        else
            requestPermission();

    }


    private boolean checkPermission()
    {
        int result= ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE);
        if(result== PackageManager.PERMISSION_GRANTED)
            return true;
        else
            return false;
    }

    private void requestPermission()
    {
        String[] permissions={Manifest.permission.READ_PHONE_STATE,Manifest.permission.RECORD_AUDIO,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.READ_PHONE_STATE))
            Toast.makeText(getApplicationContext(),"Phone Permissions needed",Toast.LENGTH_LONG);
        else
            ActivityCompat.requestPermissions(MainActivity.this,permissions,1);
    }


    public void onRequestPermissionsResult(int requestCode,String permissions[],int[] grantResults)
    {
        switch(requestCode)
        {
            case 1:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(getApplicationContext(),"Permission Granted to access Phone calls",Toast.LENGTH_LONG);
                else
                    Toast.makeText(getApplicationContext(),"You can't access Phone calls",Toast.LENGTH_LONG);
                break;
        }

    }

}
