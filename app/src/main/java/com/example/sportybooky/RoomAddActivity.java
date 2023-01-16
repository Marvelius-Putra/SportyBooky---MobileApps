package com.example.sportybooky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RoomAddActivity extends AppCompatActivity {
//    declare component variable
    EditText input_roomName, input_roomSport, input_roomLocation, input_roomMaxPeople;
    FirebaseDatabase fDatabase;
    DatabaseReference reference;
    String name, sport, location, roomID, max_people;
    Integer num_random,  current_people, maximum_people;
    Button save_newRoom;
    ImageButton back;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        access the layout
        setContentView(R.layout.activity_room_add);
        num_random = (int)(Math.random() * 100) + 1;

//        access the component to the layout component id
        input_roomName = findViewById(R.id.roomName_input);
        input_roomSport = findViewById(R.id.roomSport_input);
        input_roomLocation = findViewById(R.id.roomLocation_input);
        input_roomMaxPeople = findViewById(R.id.roomMax_input);
        save_newRoom =  findViewById(R.id.btn_SaveRoom);
        back = findViewById(R.id.addBack);

//        method to go previews page
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoomAddActivity.this, RoomActivity.class));
            }
        });

//save room method
        save_newRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newRoom();
            }
        });
    }

    private void newRoom() {
//        declare database and choose the root rooms
        fDatabase = FirebaseDatabase.getInstance();
        reference = fDatabase.getReference("rooms");

//      get the user input
        name = input_roomName.getText().toString();
        sport = input_roomSport.getText().toString();
        location = input_roomLocation.getText().toString();
        max_people = input_roomMaxPeople.getText().toString();
        maximum_people=Integer.parseInt(max_people);
        current_people = 1;
        roomID = "RM" + num_random;

//input condition
        if(TextUtils.isEmpty(name)){
            input_roomName.setError("Name is required");
            return;
        }
        if(TextUtils.isEmpty(sport)){
            input_roomSport.setError("sport is required");
            return;
        }
        if(TextUtils.isEmpty(location)){
            input_roomLocation.setError("location is required");
            return;
        }
        if(TextUtils.isEmpty(max_people)){
            input_roomMaxPeople.setError("max_people is required");
            return;
        }

//        insert into rooms database
        RoomModel room = new RoomModel(location, maximum_people, current_people, name, roomID, sport);
        reference.child(roomID).setValue(room);
        Toast.makeText(RoomAddActivity.this, "New Room Success", Toast.LENGTH_LONG).show();
        startActivity(new Intent(RoomAddActivity.this, RoomChatActivity.class));
    }
}