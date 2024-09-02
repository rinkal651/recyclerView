package com.example.learningproejct;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntentMainActivity extends AppCompatActivity {

    Button btnGmail, btnMessage, btnCall, btnShare, btnPlay, btnPause, btnStop, btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_main);
        btnCall = findViewById(R.id.btn_call);
        btnGmail = findViewById(R.id.btn_gmail);
        btnNext = findViewById(R.id.btn_next);

        btnShare = findViewById(R.id.btn_share);
        btnMessage = findViewById(R.id.btn_message);
        btnPlay = findViewById(R.id.btn_play);

        btnPause = findViewById(R.id.btn_pause);
        btnStop = findViewById(R.id.btn_stop);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
               // iDial.setAction(Intent.ACTION_DIAL)

                iDial.setData(Uri.parse("tel: +91 9724404704"));
                startActivity(iDial);
            }
        });

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMessgae = new Intent(Intent.ACTION_SENDTO);
                iMessgae.setData(Uri.parse("SMSTO: "+Uri.encode("+91 9724404704")));
                iMessgae.putExtra("SMS_body", "Please Bachavo mne");
                startActivity(iMessgae);
            }
        });

        btnGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"abc@gmail.com", "akt@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT, "Queries");
                iEmail.putExtra(Intent.EXTRA_TEXT, "Please leave me");
                startActivity(Intent.createChooser(iEmail, "Email via"));
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT, "Please download app:dwnbquygf");
                startActivity(Intent.createChooser(iShare, "Share via"));
            }
        });

        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        //String path = "android:resource://"+getPackageName()+"/raw/android_11";
        String audioUrl = "https://file-examples.com/storage/fed4cf5e5466cf5da9e984e/2017/11/file_example_MP3_700KB.mp3";
        Uri audioUri = Uri.parse(audioUrl);
        try {
            mp.setDataSource(this, audioUri);
            mp.prepare();
        } catch (Exception e) {

        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
                mp.seekTo(0);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentMainActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
    }
}