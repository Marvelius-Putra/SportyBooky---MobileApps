package com.example.sportybooky;

public class RoomModel {
//    declare room atributte according on database
    String location;
    Integer max_participant;
    Integer current_participant;
    String name;
    String roomID;
    String sport;

//    no argument constructor
    public RoomModel(){

    }

//    room constructor
    public RoomModel(String location, Integer max_participant, Integer current_participant, String name, String roomID, String sport) {
        this.location = location;
        this.max_participant = max_participant;
        this.current_participant = current_participant;
        this.name = name;
        this.roomID = roomID;
        this.sport = sport;
    }

//    setter and getter
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMax_participant() {
        return max_participant;
    }

    public void setMax_participant(Integer max_participant) {
        this.max_participant = max_participant;
    }

    public Integer getCurrent_participant() {
        return current_participant;
    }

    public void setCurrent_participant(Integer current_participant) {
        this.current_participant = current_participant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
