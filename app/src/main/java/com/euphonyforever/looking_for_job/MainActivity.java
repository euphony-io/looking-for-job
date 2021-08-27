package com.euphonyforever.looking_for_job;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

import euphony.lib.receiver.EuRxManager;


public class MainActivity extends AppCompatActivity {

    private final int MY_PERMISSIONS_REQUEST_RECORD_AUDIO = 17389;

    private View mainLayout;
    private Button btnSend;
    private Button btnReceive;

    private Context mContext;

    private EuRxManager mRxManager = new EuRxManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        btnSend = findViewById(R.id.btnSend);
        btnReceive = findViewById(R.id.btnReceive);

        mContext = this;

        btnSend.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, InputResumeInfo.class);
            startActivity(intent);
        });

        mRxManager.setAcousticSensor(letters -> {
            if(letters != null && letters.isEmpty()) {
                mRxManager.finish();
            }else{
                Intent intent = new Intent(mContext, OutputResumeInfo.class);
                intent.putExtra("info", letters);
                startActivity(intent);
            }
        });

        btnReceive.setOnClickListener(view -> {
            // recorder request should be checked.
            if (ContextCompat.checkSelfPermission(mContext,
                    Manifest.permission.RECORD_AUDIO)
                    != PackageManager.PERMISSION_GRANTED) {
                requestRecorderPermission();
            } else {
                mRxManager.listen();  //Listening Start
            }

        });

        requestRecorderPermission();
    }

    public void mOnClick(View view) {
        Intent intent = new Intent(this, InputResumeInfo.class);
        startActivity(intent);
    }

    private void requestRecorderPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.RECORD_AUDIO)) {
                Snackbar.make(mainLayout, R.string.recorder_access_required,
                        Snackbar.LENGTH_INDEFINITE).setAction(R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Request the permission
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.RECORD_AUDIO},
                                MY_PERMISSIONS_REQUEST_RECORD_AUDIO);
                    }
                }).show();
            } else {
                Snackbar.make(mainLayout, R.string.recorder_unavailable, Snackbar.LENGTH_SHORT).show();
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECORD_AUDIO},
                        MY_PERMISSIONS_REQUEST_RECORD_AUDIO);
            }
        } else {
            // Permission has already been granted
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_RECORD_AUDIO:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Snackbar.make(mainLayout, R.string.recorder_permission_granted,
                            Snackbar.LENGTH_SHORT)
                            .show();
                } else {
                    Snackbar.make(mainLayout, R.string.recorder_permission_rejected,
                            Snackbar.LENGTH_SHORT)
                            .show();
                }
        }
    }
}