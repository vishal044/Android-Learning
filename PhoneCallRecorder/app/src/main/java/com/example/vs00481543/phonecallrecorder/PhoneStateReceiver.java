package com.example.vs00481543.phonecallrecorder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.provider.Telephony;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

/**
 * Created by VS00481543 on 25-10-2017.
 */

public class PhoneStateReceiver extends BroadcastReceiver {

    MediaRecorder recorder;
    static final String TAG="State";
    static final String TAG1=" Inside State";
    static Boolean recordStarted;

    @Override
    public void onReceive(Context context, Intent intent) {
        try{
            System.out.println("Receiver Start");

            Bundle extras=intent.getExtras();
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            Log.d(TAG, " onReceive: "+state);
            Toast.makeText(context, "Call detected(Incoming/Outgoing) "+state, Toast.LENGTH_SHORT).show();

            if(extras!=null) {
                if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {

                    Log.d(TAG1, " recordStarted "+recordStarted);
                    Log.d(TAG1, " Inside "+state);

                    context.startService(new Intent(context,RecorderService.class));

                    /*recorder = new MediaRecorder();
                    recorder.reset();*/

                    /*File sdCard= Environment.getExternalStorageDirectory();
                    File recording=new File(sdCard,"myRecord");
                    if(!recording.exists())
                    {
                        System.out.println("inside if");
                        recording.mkdir();
                    }
                    String rec=recording.getAbsolutePath()+"/Record"+".3gp";*/

                    /*String rec="sdcard/MyRecord.3gp";

                    recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    recorder.setOutputFile(rec);*/

                    /*recorder.prepare();
                    recorder.start();*/
                    recordStarted=true;

                }
                else if(state.equals(TelephonyManager.EXTRA_STATE_IDLE))
                {
                    Log.d(TAG1, " Inside "+state);
                    Log.d(TAG1, " recordStarted "+recordStarted);

                    if(recordStarted)
                    {
                        Log.d(TAG1, " Inside to stop recorder "+state);

                        context.stopService(new Intent(context,RecorderService.class));

                        /*recorder.stop();
                        recorder.reset();
                        recorder.release();
                        recorder=null;*/

                        recordStarted=false;
                    }

                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
