package com.euphonyforever.looking_for_job;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OutputResumeInfo extends AppCompatActivity
{

    TextView textViewName, textViewBirth, textViewNumber, textViewAddress, textViewCareer;
    String name, birth, number, address, career;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_resume_info);

        Intent intent = getIntent();
        String info = intent.getExtras().getString("info");
        Log.d("Test", info);
//        name = intent.getExtras().getString("name");
//        birth = intent.getExtras().getString("birth");
//        number = intent.getExtras().getString("number");
//        address = intent.getExtras().getString("address");
//        career = intent.getExtras().getString("career");

        textViewName = (TextView) findViewById(R.id.nameData);
        textViewBirth = (TextView) findViewById(R.id.birthData);
        textViewNumber = (TextView) findViewById(R.id.numberData );
        textViewAddress = (TextView) findViewById(R.id.addressData);
        textViewCareer = (TextView) findViewById(R.id.careerData);

        textViewName.setText(name);
        textViewBirth.setText(birth);
        textViewNumber.setText(number);
        textViewAddress.setText(address);
        textViewCareer.setText(career);
    }
}
