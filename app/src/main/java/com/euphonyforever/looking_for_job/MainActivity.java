package com.euphonyforever.looking_for_job;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import euphony.lib.transmitter.EuDataEncoder;
import euphony.lib.transmitter.EuTxManager;
import euphony.lib.receiver.AcousticSensor;
import euphony.lib.receiver.EuRxManager;

public class MainActivity extends AppCompatActivity {

    Button buttonSend;
    Button buttonReceive;

    EuTxManager mTxManager = new EuTxManager() ;
    EuDataEncoder mSpeakText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSend = findViewById(R.id.buttonSend) ;

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), ~~Activity.class) ;
                //startActivity(intent) ;
            }
        }) ;
    }
}