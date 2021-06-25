package com.gepardec.tdd.models;

public class User {
    private String id;
    private String username;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
