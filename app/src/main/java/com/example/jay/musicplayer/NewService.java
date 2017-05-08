package com.example.jay.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class NewService extends Service {

    MediaPlayer mplayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
        //Added a music file called summer in raw directory
        mplayer = MediaPlayer.create(this,R.raw.summer);
        mplayer.setLooping(true); // Set looping
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handleStart(intent, startId);
        return START_NOT_STICKY;
        //onStart method is deprecated so used onStartCommand
    }

     void handleStart(Intent intent, int startId) {
         Toast.makeText(this, "Service has Started", Toast.LENGTH_SHORT).show();
         mplayer.start();
         //Start if you want to listen to music
     }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service has Stopped", Toast.LENGTH_SHORT).show();

        mplayer.stop();
        //Stop if you want to shut it
    }

}
