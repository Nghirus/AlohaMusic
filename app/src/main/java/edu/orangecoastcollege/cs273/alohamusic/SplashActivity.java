package edu.orangecoastcollege.cs273.alohamusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //create TimerTask to defer loading of MusicActivity by 3 seconds.
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //Finish the current SplashActivity, then:
                finish();
                // Launch MusicActivity
                Intent musicIntent = new Intent(SplashActivity.this,MusicActivity.class);
                startActivity(musicIntent);
            }
        };

        //run Timertask after 3 seconds (3000ms)
        Timer timer = new Timer();
        timer.schedule(task, 3000 );
    }
}
