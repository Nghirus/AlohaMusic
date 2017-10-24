package edu.orangecoastcollege.cs273.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MusicActivity extends AppCompatActivity {

    private Button ukuleleButton;
    private Button ipuButton;
    private Button hulaButton;

    VideoView hulaVideoView;
    MediaPlayer ukuleleMediaPlayer;
    MediaPlayer ipuMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ukuleleButton = (Button) findViewById(R.id.ukuleleButton);
        ipuButton = (Button) findViewById(R.id.ipuButton);
        hulaButton = (Button) findViewById(R.id.hulaButton);
        hulaVideoView = (VideoView) findViewById(R.id.hulaVideoView);

        ukuleleMediaPlayer = MediaPlayer.create(this, R.raw.ukulele);
        ipuMediaPlayer = MediaPlayer.create(this,R.raw.ipu);

        String uri = "android.resource://" + getPackageName() + "/" + R.raw.hula;
        hulaVideoView.setVideoURI(Uri.parse(uri));
        hulaVideoView.setMediaController(new MediaController(this));
    }

    public void playMedia(View v) {
        //Make a decision based on id of the view.
        switch (v.getId()) {
            case (R.id.ukuleleButton):
                if (ukuleleMediaPlayer.isPlaying()) {
                    ukuleleMediaPlayer.pause();
                    ukuleleButton.setText(R.string.ukulele_button_play_text);
                    hulaButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    ukuleleMediaPlayer.start();
                    ukuleleButton.setText(R.string.ukulele_button_pause_text);
                    hulaButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);
                }
                break;

            case (R.id.ipuButton):
                if(ipuMediaPlayer.isPlaying())
                {
                    ipuMediaPlayer.pause();
                    ipuButton.setText(R.string.ipu_button_play_text);
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    ipuMediaPlayer.start();
                    ipuButton.setText(R.string.ipu_button_pause_text);
                    hulaButton.setVisibility(View.INVISIBLE);
                    ukuleleButton.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.hulaButton:
                if(hulaVideoView.isPlaying())
                {
                    hulaVideoView.pause();
                    hulaButton.setText(R.string.hula_button_watch_text);
                    ukuleleButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    hulaVideoView.start();
                    hulaButton.setText(R.string.hula_button_pause_text);
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);
                }

                break;
        }
    }
    //Override onStop to release mediaPlayers
    //Prevent memory leaks


    @Override
    protected void onStop() {
        super.onStop();
        ukuleleMediaPlayer.release();
        ipuMediaPlayer.release();
    }
}
