package com.example.sounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer = MediaPlayer.create(this, R.raw.tasmania);
    }

    public void playBtt(View view) {
        mPlayer.start();
    }

    public void pauseBtt(View view) {
        mPlayer.pause();
    }

}
