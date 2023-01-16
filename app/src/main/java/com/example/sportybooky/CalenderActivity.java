package com.example.sportybooky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalenderActivity extends AppCompatActivity {
//    declare component variables
    CalendarView calenderView;
    TextView myDate;
    Button btn_saveDate;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Access the layout activity_calender
        setContentView(R.layout.activity_calender);

//      access the layout component
        calenderView = (CalendarView) findViewById(R.id.calenderView);
        myDate = (TextView) findViewById(R.id.calenderDate);
        btn_saveDate = findViewById(R.id.saveDate);
        back = findViewById(R.id.scheduleBack);

//        method to go previews page
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalenderActivity.this, BookingActivity.class));
            }
        });

//        Calender method
        calenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (year + 1) + "/" + month + "/" + dayOfMonth;
                myDate.setText(date);
            }
        });

//        Method to checkout page
        btn_saveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalenderActivity.this, CheckoutActivity.class));
            }
        });
    }
}