package com.example.sportybooky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class statusActivity extends AppCompatActivity {
//    declare variables
    ImageButton status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        access layout activity_status
        setContentView(R.layout.activity_status);
//        access the layout component
        status = findViewById(R.id.statusSuccess);

//        method to go HomeActivity
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(statusActivity.this, HomeActivity.class));
            }
        });
    }
}