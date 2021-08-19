package com.euphonyforever.looking_for_job;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                name = editTextName.getText().toString();
                birth = editTextBirth.getText().toString();
                number = editTextNumber.getText().toString();
                address = editTextAddress.getText().toString();
                career = editTextCareer.getText().toString();

            }
        });

    }
}