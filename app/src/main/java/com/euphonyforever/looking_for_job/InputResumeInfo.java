package com.euphonyforever.looking_for_job;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import euphony.lib.transmitter.EuTxManager;

public class InputResumeInfo extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextBirth;
    private EditText editTextNumber;
    private EditText editTextAddress;
    private EditText editTextCareer;
    private Button btnSend;
    private String output = "";
    private boolean speakOn = false;

    EuTxManager mTxManager = new EuTxManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_resume_info);

        editTextName = findViewById(R.id.inputName);
        editTextBirth = findViewById(R.id.inputBirth);
        editTextNumber = findViewById(R.id.inputNumber);
        editTextAddress = findViewById(R.id.inputAddress);
        editTextCareer = findViewById(R.id.inputCareer);
        btnSend = findViewById(R.id.sendButton);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(speakOn){
                    mTxManager.stop();
                    btnSend.setText("전송");
                    speakOn = false;
                }else{
                    output += (editTextName.getText().toString() + "%");
                    output += (editTextBirth.getText().toString() + "%");
                    output += (editTextNumber.getText().toString() + "%");
                    output += (editTextAddress.getText().toString() + "%");
                    output += editTextCareer.getText().toString();

                    mTxManager.euInitTransmit(output);
                    mTxManager.process(-1);
                    btnSend.setText("중지");
                    speakOn = true;
                }
            }
        });

    }
}