package com.euphonyforever.looking_for_job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.sendButton);

        String name, birth, number, address, career;
        name = "euphony";
        birth = "2021-08-07";
        number = "010-1111-2222";
        address = "Seoul";
        career = "developer";

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OutputResumeInfo.class);
                intent.putExtra("name",name);
                intent.putExtra("birth",birth);
                intent.putExtra("number",number);
                intent.putExtra("address",address);
                intent.putExtra("career",career);
                startActivity(intent);
            }
        });


    }
}