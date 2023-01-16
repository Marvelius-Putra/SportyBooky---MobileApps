package com.example.sportybooky;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class FieldAdapter extends RecyclerView.Adapter<FieldAdapter.FieldHolder> {
//    declare  field adapter attributes
    Context context;
    ArrayList<FieldModel> Fieldlist;
    private FieldAdapter.OnItemClickListener mListener;

//  Constructor
    public FieldAdapter(Context context, ArrayList<FieldModel> list) {
        this.context = context;
        this.Fieldlist = list;
    }

    @NonNull
    @Override
//    get the component layout parent
    public FieldHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.field_component, parent, false);
        return new FieldHolder(v);
    }

//    change text on layout parent according to the arraylist position
    @Override
    public void onBindViewHolder(@NonNull FieldHolder holder, int position) {
        FieldModel model = Fieldlist.get(position);
        holder.name.setText(model.getName());
        holder.address.setText(model.getAddress());
        holder.rating.setText(Integer.toString(model.getRatings()));
        holder.price.setText(Integer.toString(model.getPrice_per_hour()) + "/jam");
        Glide.with(context).load(model.getImage()).into(holder.fieldImage);
        holder.book.setOnClickListener(v -> {
            Intent i = new Intent(context, BookingActivity.class);
            i.putExtra("fieldID", model.getFieldID());
            i.putExtra("address", model.getAddress());
            i.putExtra("image", model.getImage());
            i.putExtra("name", model.getName());
            i.putExtra("price_per_hour", model.getPrice_per_hour().toString());
            i.putExtra("ratings", model.getRatings().toString());
            i.putExtra("type", model.getType());
            context.startActivity(i);
        });
    }

//    size of array
    @Override
    public int getItemCount() {
        return Fieldlist.size();
    }

//    declare the recycle component
    public class FieldHolder extends RecyclerView.ViewHolder{
        TextView name, address, rating, price;
        ImageView fieldImage;
        Button book;


//  find the component in recycle layout
        public FieldHolder(@NonNull View itemView) {
            super(itemView);
//            cardView = itemView.findViewById(R.id.recCard);
            name = itemView.findViewById(R.id.fieldTitle);
            address = itemView.findViewById(R.id.fieldAddress);
            rating = itemView.findViewById(R.id.fieldRating);
            price = itemView.findViewById(R.id.fieldPrice);
            fieldImage = itemView.findViewById(R.id.fieldImage);
            book = itemView.findViewById(R.id.go_book);

//          Method to get the arraylist data on click from model
            book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAbsoluteAdapterPosition();
                    String address, fieldID, image, name, price_per_hour, ratings, type;

                    address = Fieldlist.get(position).getAddress();
                    fieldID = Fieldlist.get(position).getFieldID();
                    image = Fieldlist.get(position).getImage();
                    name = Fieldlist.get(position).getName();
                    price_per_hour = Fieldlist.get(position).getPrice_per_hour().toString();
                    ratings = Fieldlist.get(position).getRatings().toString();
                    type = Fieldlist.get(position).getType();

                    if(mListener != null){
                        mListener.onItemClick(fieldID,address,image, name, price_per_hour, ratings, type);
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(String fieldID, String address, String image, String name, String price_per_hour, String ratings, String type);
    }

    public void setOnItemClickListener(FieldAdapter.OnItemClickListener listener){
        mListener = listener;
    }
}
