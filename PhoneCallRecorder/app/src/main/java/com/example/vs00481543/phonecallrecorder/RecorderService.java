package com.example.vs00481543.phonecallrecorder;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

/**
 * Created by VS00481543 on 30-10-2017.
 */

public class RecorderService extends Service {

    MediaRecorder recorder;
    static final String TAGS=" Inside Service";


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent,int flags,int startId)
    {
        recorder = new MediaRecorder();
        recorder.reset();

        String rec="sdcard/MyRecord.3gp";

        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(rec);

        try {
            recorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        recorder.start();

        Log.d(TAGS, "onStartCommand: "+"Recording started");

        return START_NOT_STICKY;
    }

    public void onDestroy()
    {
        super.onDestroy();

        recorder.stop();
        recorder.reset();
        recorder.release();
        recorder=null;

        Log.d(TAGS, "onDestroy: "+"Recording stopped");


    }
}
