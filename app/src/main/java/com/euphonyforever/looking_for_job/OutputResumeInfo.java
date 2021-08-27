package com.euphonyforever.looking_for_job;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OutputResumeInfo extends AppCompatActivity
{

    TextView textViewName, textViewBirth, textViewNumber, textViewAddress, textViewCareer;
    private String name;
    private String birth;
    private String number;
    private String address;
    private String career;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_resume_info);

        Intent intent = getIntent();
        String info = intent.getExtras().getString("info");
//        name = intent.getExtras().getString("name");
//        birth = intent.getExtras().getString("birth");
//        number = intent.getExtras().getString("number");
//        address = intent.getExtras().getString("address");
//        career = intent.getExtras().getString("career");

        String[] infoArr = info.split("%");

        textViewName = (TextView) findViewById(R.id.nameData);
        textViewBirth = (TextView) findViewById(R.id.birthData);
        textViewNumber = (TextView) findViewById(R.id.numberData );
        textViewAddress = (TextView) findViewById(R.id.addressData);
        textViewCareer = (TextView) findViewById(R.id.careerData);

        name = infoArr[0];
        birth = infoArr[1];
        number = infoArr[2];
        address = infoArr[3];
        career = infoArr[4];

        textViewName.setText(name);
        textViewBirth.setText(birth);
        textViewNumber.setText(number);
        textViewAddress.setText(address);
        textViewCareer.setText(career);
    }
}
