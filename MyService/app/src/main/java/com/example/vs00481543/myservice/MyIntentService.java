package com.example.vs00481543.myservice;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.audiofx.BassBoost;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by VS00481543 on 17-08-2017.
 */

public class MyIntentService extends Service {

    private MediaPlayer player;

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public int onStartCommand(Intent intent,int flags,int startId)
    {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);

        player.setLooping(true);

        Log.d("One", "onStartCommand   "+startId);

        player.start();

        return START_STICKY;
    }

    public void onDestroy()
    {
        super.onDestroy();
        player.stop();
    }


}
