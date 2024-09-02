package com.example.learningproejct;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VideoActivity extends AppCompatActivity implements SensorEventListener {
VideoView vwVideo;
    Sensor acceleroMeter, proximity, light;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        vwVideo = findViewById(R.id.vw_video);
        String path = "https://file-examples.com/wp-content/storage/2017/04/file_example_MP4_480_1_5MG.mp4";
        Uri uri = Uri.parse(path);
        vwVideo.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        vwVideo.setMediaController(mediaController);
        mediaController.setAnchorView(vwVideo);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager != null) {
            acceleroMeter  = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            if(proximity!=null || light != null || acceleroMeter != null) {
                sensorManager.registerListener(this, acceleroMeter, SensorManager.SENSOR_DELAY_NORMAL);
                sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL);
                sensorManager.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL);
            }
        } else {
            Toast.makeText(this, "Sensor service not detected.", Toast.LENGTH_SHORT).show();
        }

        ((Button)findViewById(R.id.start_service)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(VideoActivity.this, MusicService.class));
            }
        });


        ((Button)findViewById(R.id.stop_service)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(VideoActivity.this, MusicService.class));
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            ((TextView)findViewById(R.id.tv_accelrometer)).setText(sensorEvent.values[0]+"x, "+sensorEvent.values[1]+"y, "+sensorEvent.values[2]+"z");
        }

        if(sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            ((TextView)findViewById(R.id.tv_proximity)).setText(sensorEvent.values[0]+"");
        }


        if(sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            ((TextView)findViewById(R.id.tv_light)).setText(sensorEvent.values[0]+"");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}