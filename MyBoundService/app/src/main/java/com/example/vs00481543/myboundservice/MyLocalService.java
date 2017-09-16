package com.example.vs00481543.myboundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by VS00481543 on 23-08-2017.
 */

public class MyLocalService extends Service {
    private final IBinder binder=new localBinder();

    public class localBinder extends Binder
    {
        MyLocalService getService()
        {
            return MyLocalService.this;
        }
    }

    public IBinder onBind(Intent intent) {
        return binder;
    }

    public Date getCurrentDate()
    {
        return Calendar.getInstance().getTime();
    }
}
