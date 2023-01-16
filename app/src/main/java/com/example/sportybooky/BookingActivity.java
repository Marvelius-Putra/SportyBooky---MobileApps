package com.example.sportybooky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.charset.StandardCharsets;

public class BookingActivity extends AppCompatActivity {
//    Declare variables
    ImageView dtlimage;
    TextView txtstar, txttitle, txtlocation, txtprice;
    String address, fieldID, image, name, price_per_hour, ratings, type;
    Button book;
    ImageButton back;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        access the layout activity_booking
        setContentView(R.layout.activity_booking);

//      access the layout component
        dtlimage = findViewById(R.id.detailImage);
        txtstar = findViewById(R.id.star);
        txttitle = findViewById(R.id.detailName);
        txtlocation = findViewById(R.id.detailLocation);
        txtprice = findViewById(R.id.detailPrice);
        book = (Button) findViewById(R.id.btn_book);
        back = (ImageButton) findViewById(R.id.detailBack);

//      get the data from the previews activity
        Intent intent = getIntent();
        address = intent.getStringExtra("address");
        fieldID = intent.getStringExtra("fieldID");
        image = intent.getStringExtra("image");
        name = intent.getStringExtra("name");
        price_per_hour = intent.getStringExtra("price_per_hour");
        ratings = intent.getStringExtra("ratings");
        type = intent.getStringExtra("type");

//        Change the text on xml
        txtstar.setText(ratings);
        txttitle.setText(name);
        txtprice.setText(price_per_hour);
        txtlocation.setText(address);

//        method to calender activity
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookingActivity.this, CalenderActivity.class));
            }
        });

        //        method to go back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookingActivity.this, HomeActivity.class));
                finishAffinity();
            }
        });

    }
}