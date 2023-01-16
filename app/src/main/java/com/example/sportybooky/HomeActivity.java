package com.example.sportybooky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {

//    declare component variables
    TextView username, email;
    FirebaseDatabase fDatabase;
    String userID, sportID;
    Button btnlogout ;
    ImageView field, room;
    private FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Access layout activity_home
        setContentView(R.layout.activity_home);

//        find the component id in the layout
        username = findViewById(R.id.textUsername);
        field = findViewById(R.id.go_field);
        room = findViewById(R.id.go_room);
        fAuth = FirebaseAuth.getInstance();
        userID = fAuth.getCurrentUser().getUid();

//        get the user data from database
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = reference.child("users");
        Query query = ref.orderByChild("UserID").equalTo(userID);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot ds : snapshot.getChildren()){
                        username.setText("Hi " + ds.child("Name").getValue().toString());
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });

//        method to go to the field page
        field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this , SportActivity.class));
            }
        });

//        method to go to room page
        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, RoomActivity.class));
            }
        });
    }
}