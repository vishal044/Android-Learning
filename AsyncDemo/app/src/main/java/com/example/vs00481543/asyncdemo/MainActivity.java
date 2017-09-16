package com.example.vs00481543.asyncdemo;

import android.app.Application;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    Button butClick;
    public static final int progress_bar_type = 0;
    ProgressDialog prgDialog;
    private static String file_url = "http://programmerguru.com/android-tutorial/wp-content/uploads/2014/01/jai_ho.mp3";
    private MediaPlayer mPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butClick = (Button) findViewById(R.id.but);

        butClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butClick.setEnabled(false);

                File file = new File(Environment.getExternalStorageDirectory().getPath() + "/--- Jai Ho.mp3");

                if (file.exists()) {
                    Toast.makeText(getApplicationContext(), "File already exists", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "File downlaoding", Toast.LENGTH_SHORT).show();
                    new DownloadTask().execute(file_url);
                }
            }
        });
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type:
                prgDialog = new ProgressDialog(this);
                prgDialog.setMessage("Downloading Mp3 file. Please wait...");
                prgDialog.setIndeterminate(false);
                prgDialog.setMax(100);
                prgDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                prgDialog.setCancelable(false);
                prgDialog.show();
                return prgDialog;

            default:
                return null;
        }
    }


    public class DownloadTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(progress_bar_type);
        }


        protected String doInBackground(String... f_url) {
            int count;
            try {
                URL url = new URL(f_url[0]);
                URLConnection con = url.openConnection();
                con.connect();
                int lengthOfFile = con.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream(), 10 * 1024);
                OutputStream output = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + "/jai_ho.mp3");
                byte data[] = new byte[1024];
                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    publishProgress("" + (int) ((total * 100) / lengthOfFile));
                    output.write(data, 0, count);
                }
                output.flush();
                output.close();
                input.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            prgDialog.setProgress(Integer.parseInt(values[0]));
        }

        @Override
        protected void onPostExecute(String file_url) {
            super.onPostExecute(file_url);
            dismissDialog(progress_bar_type);
            Toast.makeText(getApplicationContext(), "Download complete, playing Music", Toast.LENGTH_LONG).show();
            playMusic();
        }
    }

    protected void playMusic()
    {
        Uri muUri=Uri.parse("file:///sdcard/jai_ho.mp3");
        mPlayer=new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try{
            mPlayer.setDataSource(getApplicationContext(),muUri);
            mPlayer.prepare();
            mPlayer.start();
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    butClick.setEnabled(true);
                    Toast.makeText(getApplicationContext(), "Music completed playing",Toast.LENGTH_LONG).show();
                }
            });
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



}
