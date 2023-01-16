package com.example.sportybooky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckoutActivity extends AppCompatActivity {
//    declare component variable
    Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        access layout
        setContentView(R.layout.activity_checkout);
//        //      access the layout component
        pay = findViewById(R.id.btn_pay);

//      method to statusActivity
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckoutActivity.this, statusActivity.class));
            }
        });
    }
}