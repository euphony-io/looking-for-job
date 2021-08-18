package com.euphonyforever.looking_for_job;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputResumeInfo extends AppCompatActivity {

    EditText editTextName;
    EditText editTextBirth;
    EditText editTextNumber;
    EditText editTextAddress;
    EditText editTextCareer;
    Button btnSend;

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
                String name = editTextName.getText().toString();
                String birth = editTextBirth.getText().toString();
                String number = editTextNumber.getText().toString();
                String address = editTextAddress.getText().toString();
                String career = editTextCareer.getText().toString();

            }
        });

    }
}