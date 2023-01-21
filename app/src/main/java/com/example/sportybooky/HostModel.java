package com.example.sportybooky;

//host model for the host who make the room
public class HostModel extends UserModel {
    String host_id;

    public HostModel(String username, String email, String password, String id, String host_id) {
        super(username, email, password, id);
        this.host_id = host_id;
    }
}
