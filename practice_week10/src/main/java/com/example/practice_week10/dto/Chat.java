package com.example.practice_week10.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Chat {
    private String roomName;
    private List<String> users;

    public Chat(String roomName) {
        this.roomName = roomName;
        this.users = new ArrayList<>();
    }
}
