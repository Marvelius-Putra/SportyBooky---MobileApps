package com.example.sportybooky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RoomActivity extends AppCompatActivity {
//    declare component variables
    RecyclerView recyclerView;
    DatabaseReference database;
    RoomAdapter roomAdapter;
    ArrayList<RoomModel> list;
    Button addRoom;
    Button joinRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        access the layout
        setContentView(R.layout.activity_room);

//       access the component id layout
        recyclerView = findViewById(R.id.roomRecycle);
        database = FirebaseDatabase.getInstance().getReference("rooms");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        addRoom = (Button) findViewById(R.id.btn_roomAdd);

//        method to go addroom page
        addRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoomActivity.this, RoomAddActivity.class));
            }
        });

//        get the arraylist from adapter
        list = new ArrayList<>();
        roomAdapter = new RoomAdapter(this, list);
        recyclerView.setAdapter(roomAdapter);

//        get room variable in database
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    RoomModel model = dataSnapshot.getValue(RoomModel.class);
                    list.add(model);
                }
                roomAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}