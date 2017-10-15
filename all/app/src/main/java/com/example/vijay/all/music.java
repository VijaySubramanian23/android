package com.example.vijay.all;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class music extends AppCompatActivity {
    MediaPlayer m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        m= MediaPlayer.create(this,R.raw.music);
    }
    public void play(View view){

        m.start();
    }
    public void pause(View view){

        m.pause();
    }
}
