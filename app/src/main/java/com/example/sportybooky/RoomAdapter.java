package com.example.sportybooky;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomHolder> {
//    declare the adapter atribute
    Context context;
    ArrayList<RoomModel> list;

//    adapter constructor
    public RoomAdapter(Context context, ArrayList<RoomModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RoomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        access the layout parent component
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_component, parent, false);
        return new RoomHolder(v);
    }

//    to change the component in the parent layout according to arraylist position
    @Override
    public void onBindViewHolder(@NonNull RoomHolder holder, int position) {
        RoomModel model = list.get(position);
        holder.name.setText(model.getName());
        holder.sport.setText(model.getSport());
        holder.location.setText(model.getLocation());
        holder.current_player.setText(model.getCurrent_participant() + "/" + Integer.toString(model.getMax_participant()));
        holder.joinChat.setOnClickListener(new View.OnClickListener() {
            @Override
//            get the arraylist data when clicked
            public void onClick(View v) {
                if(model.current_participant <= model.max_participant){
                    model.current_participant++;
                    Intent i = new Intent(context, RoomChatActivity.class);
                    i.putExtra("name", model.getName());
                    i.putExtra("sport", model.getSport());
                    i.putExtra("location", model.getLocation());
                    i.putExtra("current_player", model.getCurrent_participant().toString());
                    i.putExtra("max_player", model.getMax_participant().toString());
                    context.startActivity(i);
                }
                else{
                    Toast.makeText(context.getApplicationContext(),"Room is Full",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    size of the room
    @Override
    public int getItemCount() {
        return list.size();
    }

//    get the component layout id
    public static class RoomHolder extends RecyclerView.ViewHolder{
        TextView name, sport, location, current_player, max_player;
        Button joinChat;
        public RoomHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.roomName);
            sport = itemView.findViewById(R.id.roomType);
            location = itemView.findViewById(R.id.roomLocation);
            current_player = itemView.findViewById(R.id.roomCurrent);
            joinChat = itemView.findViewById(R.id.go_joinChat);
        }
    }
}
