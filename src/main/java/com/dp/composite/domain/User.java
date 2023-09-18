package com.dp.composite.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private String username;
    private String password;
    private List<String> resources;
    private List<String> roles;

    public User() {

    }

    public User(String username, String password, List<String> resources, List<String> roles) {
        this.username = username;
        this.password = password;
        this.resources = resources;
        this.roles = roles;
    }

}
