package com.euphonyforever.looking_for_job;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    Button btnSend;
    Button btnReceive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InputResumeInfo.class);
                startActivity(intent);
            }
        });
    }

    public void mOnClick(View view) {
        Intent intent = new Intent(this, InputResumeInfo.class);
        startActivity(intent);
    }
}