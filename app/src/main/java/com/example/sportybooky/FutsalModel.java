package com.example.sportybooky;

public class FutsalModel extends FieldModel{
    Integer ball_stock;

    public FutsalModel(Integer ball_stock) {
        this.ball_stock = ball_stock;
    }

    public FutsalModel(String address, String fieldID, String image, String name, Integer price_per_hour, Integer ratings, String type, Integer ball_stock) {
        super(address, fieldID, image, name, price_per_hour, ratings, type);
        this.ball_stock = ball_stock;
    }
}
