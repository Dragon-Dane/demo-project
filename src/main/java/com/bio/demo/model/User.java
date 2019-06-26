package com.bio.demo.model;

import lombok.Data;

@Data
public class User {
    private String status;

    public User(String status) {
        this.status = status;
    }
}
