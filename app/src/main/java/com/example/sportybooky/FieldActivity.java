package com.example.sportybooky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class FieldActivity extends AppCompatActivity {

//  Declare Component Variable
    RecyclerView recyclerView;
    DatabaseReference database;
    FieldAdapter fieldAdapter;
    ArrayList<FieldModel> list;
    Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Access layout activity_field
        setContentView(R.layout.activity_field);

//      access the layout component
        recyclerView = findViewById(R.id.fieldRecycle);
        database = FirebaseDatabase.getInstance().getReference("sports");
        recyclerView.setHasFixedSize(true);
        book = findViewById(R.id.go_book);

//      manage the recyclerview
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fieldAdapter = new FieldAdapter(this, list);
        recyclerView.setAdapter(fieldAdapter);

//        get variable from previews page
        Intent intent = getIntent();
        int flag = getIntent().getExtras().getInt("flag");


//        search data from database
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                search badminton type
                if(flag == 1){
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        FieldModel model = postSnapshot.getValue(FieldModel.class);
                        if(postSnapshot.getValue(FieldModel.class).getType().equals("Badminton")){
                            list.add(model);
                        }
                    }
                    fieldAdapter.notifyDataSetChanged();
                }

//                search futsal type
                if(flag == 2){
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        FieldModel model = postSnapshot.getValue(FieldModel.class);
                        if(postSnapshot.getValue(FieldModel.class).getType().equals("Futsal")){
                            list.add(model);
                        }
                    }
                    fieldAdapter.notifyDataSetChanged();
                }
//                search tennis type
                if(flag == 3){
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        FieldModel model = postSnapshot.getValue(FieldModel.class);
                        if(postSnapshot.getValue(FieldModel.class).getType().equals("Tennis")){
                            list.add(model);
                        }
                    }
                    fieldAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

    }
}