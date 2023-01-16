package com.example.sportybooky;

public class FieldModel {
//    declare the field atribut according in database
    String address;
    String fieldID;
    String image;
    String name;
    Integer price_per_hour;
    Integer ratings;
    String type;

//    no argument constructor
    public FieldModel(){

    }

//    constructor
    public FieldModel(String address, String fieldID, String image, String name, Integer price_per_hour, Integer ratings, String type) {
        this.address = address;
        this.fieldID = fieldID;
        this.image = image;
        this.name = name;
        this.price_per_hour = price_per_hour;
        this.ratings = ratings;
        this.type = type;
    }

//    Getter and Setter (inheritance)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFieldID() {
        return fieldID;
    }

    public void setFieldID(String fieldID) {
        this.fieldID = fieldID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice_per_hour() {
        return price_per_hour;
    }

    public void setPrice_per_hour(Integer price_per_hour) {
        this.price_per_hour = price_per_hour;
    }

    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
