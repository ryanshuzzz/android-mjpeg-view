package com.longdo.mjpegview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.longdo.mjpegviewer.MjpegView;


public class MainActivity extends AppCompatActivity {

    private MjpegView view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view1 = findViewById(R.id.mjpegview1);
        view1.setAdjustHeight(true);
        //view.setAdjustWidth(true);
        view1.setMode(MjpegView.MODE_FIT_WIDTH);
        //view.setMsecWaitAfterReadImageError(1000);
        view1.setUrl("https://office.hubsai.com:9002/api/services/camera_proxy_stream/camera_02");
        view1.setToken("92b957c78bec4150badab344d8ab3e1a");
        view1.setRecycleBitmap(true);
    }

    @Override
    protected void onResume() {
        view1.startStream();
        super.onResume();
    }

    @Override
    protected void onPause() {
        view1.stopStream();
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
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

    @Override
    protected void onStop() {
        view1.stopStream();
        super.onStop();
    }
}
