package com.euphonyforever.looking_for_job;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import euphony.lib.transmitter.EuTxManager;

public class InputResumeInfo extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextBirth;
    private EditText editTextNumber;
    private EditText editTextAddress;
    private EditText editTextCareer;
    private Button btnSend;
    private String name;
    private String birth;
    private String number;
    private String address;
    private String career;
    private Map<String, String> data = new HashMap<>();

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
                data.put("name", editTextName.getText().toString());
                data.put("birth", editTextBirth.getText().toString());
                data.put("number", editTextNumber.getText().toString());
                data.put("address", editTextAddress.getText().toString());
                data.put("career", editTextCareer.getText().toString());

                Gson gson = new Gson();
                String output = gson.toJson(data);

                mTxManager.euInitTransmit(output);
                mTxManager.process(1);
            }
        });

    }
}