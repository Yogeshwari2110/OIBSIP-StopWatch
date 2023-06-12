package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class stopwatch extends AppCompatActivity {
    private Chronometer chrono;
    private long holdOffset;
    private boolean run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stopwatch);

        chrono=findViewById(R.id.chronometer);
        chrono.setFormat("Time:%s");


    }

    public void startTiming(View v){
        if(!run){
            chrono.setBase(SystemClock.elapsedRealtime() - holdOffset); //to start from system time
            chrono.start();
            run=true;
        }

    }

    public void holdTiming(View v){
        if(run){

            chrono.stop();
            holdOffset=SystemClock.elapsedRealtime()-chrono.getBase();
            run=false;
        }

    }

    public void stopTiming(View v){

        chrono.setBase(SystemClock.elapsedRealtime());
        holdOffset=0;

    }
}