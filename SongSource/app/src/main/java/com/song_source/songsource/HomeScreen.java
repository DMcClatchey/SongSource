package com.song_source.songsource;

//import android.media.session.MediaController;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.VideoView;
import android.widget.MediaController;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        VideoView firstvid = (VideoView) findViewById(R.id.FirstVid);
        MediaController mediacontroller = new MediaController(this);
        mediacontroller.setAnchorView(firstvid);
        String uriPath = "android.resource://com.song_source.songsource/" + R.raw.sufjanufo;
        Uri video = Uri.parse(uriPath);
        firstvid.setMediaController(mediacontroller);
        firstvid.setVideoURI(video);
        firstvid.start();

        VideoView secondvid = (VideoView) findViewById(R.id.SecondVid);
        MediaController mediacontrollertwo = new MediaController(this);
        mediacontroller.setAnchorView(secondvid);
        String uriPathtwo = "android.resource://com.song_source.songsource/" + R.raw.sufjan4thjuly;
        Uri videotwo = Uri.parse(uriPathtwo);
        secondvid.setMediaController(mediacontrollertwo);
        secondvid.setVideoURI(videotwo);
        secondvid.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
