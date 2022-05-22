package com.example.stopwatchjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

public class StopwatchActivity extends AppCompatActivity {
    private int allSeconds = 0;
    private boolean isRun;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            allSeconds = savedInstanceState.getInt("sec");
            isRun = savedInstanceState.getBoolean("run");
            wasRunning = savedInstanceState.getBoolean("wasRun");
        }

        runTimer();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("sec", allSeconds);
        savedInstanceState.putBoolean("run", isRun);
        savedInstanceState.putBoolean("wasRun", wasRunning);
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = isRun;
        isRun = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning)
            isRun = true;
    }

    public void onClickStart(View view){
        isRun = true;
    }

    public void onClickStop(View view){
        isRun = false;
    }

    public void onClickReset(View view){
        isRun = false;
        allSeconds = 0;
    }

    private void runTimer(){
        final TextView timeView = findViewById(R.id.time_view);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = allSeconds / 3600;
                int minutes = (allSeconds % 3600) / 60;
                int seconds = allSeconds % 60;

                String time = String.format(Locale.getDefault(),
                        "%02d:%02d:%02d", hours, minutes, seconds);
                timeView.setText(time);

                if (isRun) allSeconds++;
                handler.postDelayed(this, 1000);
            }
        });
    }
}