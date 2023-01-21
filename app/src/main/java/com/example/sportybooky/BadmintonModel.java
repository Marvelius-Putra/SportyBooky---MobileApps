package com.example.sportybooky;

public class BadmintonModel extends FieldModel{
    Integer Racket_stock;

    public BadmintonModel() {
    }

    public BadmintonModel(String address, String fieldID, String image, String name, Integer price_per_hour, Integer ratings, String type) {
        super(address, fieldID, image, name, price_per_hour, ratings, type);
    }

    public BadmintonModel(String address, String fieldID, String image, String name, Integer price_per_hour, Integer ratings, String type, Integer racket_stock) {
        super(address, fieldID, image, name, price_per_hour, ratings, type);
        this.Racket_stock = racket_stock;
    }
}
