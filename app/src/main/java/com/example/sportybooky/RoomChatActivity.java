package com.example.sportybooky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class RoomChatActivity extends AppCompatActivity {
//    declare component variables
    ImageButton back;
    TextView participant;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        access the layout
        setContentView(R.layout.activity_room_chat);

//      access the layout component
        participant = findViewById(R.id.chatParticipant);
        back = findViewById(R.id.goBack);

//        go to previews page
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoomChatActivity.this, HomeActivity.class));
            }
        });
    }
}