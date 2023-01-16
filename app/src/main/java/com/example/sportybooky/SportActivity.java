package com.example.sportybooky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SportActivity extends AppCompatActivity {
//    declare variables
    ImageView badminton, futsal, tennis;
    Integer flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        access the layout activity_sport
        setContentView(R.layout.activity_sport);
//        access the layout components
        badminton = (ImageView) findViewById(R.id.go_badminton);
        futsal = (ImageView) findViewById(R.id.go_bola);
        tennis = (ImageView) findViewById(R.id.go_tennis);

//        method to FieldActivity page
        badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 1;
                Intent i = new Intent(SportActivity.this, FieldActivity.class);
                i.putExtra("flag",flag);
                startActivity(i);
            }
        });

//        method to FieldActivity page
        futsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 2;
                Intent i = new Intent(SportActivity.this, FieldActivity.class);
                i.putExtra("flag",flag);
                startActivity(i);
            }
        });

//        method to FieldActivity page
        tennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 3;
                Intent i = new Intent(SportActivity.this, FieldActivity.class);
                i.putExtra("flag",flag);
                startActivity(i);
            }
        });
    }
}