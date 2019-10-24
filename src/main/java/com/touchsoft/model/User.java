package com.touchsoft.model;

import lombok.Data;

@Data
public class User {
    static public String roomName;
    static public String role;
    static public String username;
    static public String password;
    static public String token;


    public static void setRoomName(String name, String role) {
        User.roomName = name + "_" + role;
    }
}
