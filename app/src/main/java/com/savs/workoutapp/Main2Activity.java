package com.savs.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {
    MediaPlayer m1;
    TextView timer;
    EditText sets;
    MediaPlayer music;
    AudioManager audiomanager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        music = MediaPlayer.create(this, R.raw.song1);
        sets = findViewById(R.id.sets);
        audiomanager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxvol = audiomanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentvol = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC);
      //  SeekBar volumeRocker = findViewById(R.id.seek);
      //  volumeRocker.setMax(maxvol);
      //  volumeRocker.setProgress(currentvol);

        final SeekBar timeline = findViewById(R.id.seek);
        timeline.setMax(music.getDuration());
        timeline.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                music.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeline.setProgress(music.getCurrentPosition());
            }
        }, 0, 1000);

        m1 = MediaPlayer.create(this,R.raw.sixth);
        timer= findViewById(R.id.timer);
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
               timer.setText(" "+String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                m1.start();
                music.start();

            }
        }.start();
    }

}
