package com.dp.composite.domain;

import lombok.Data;

import java.util.List;

@Data
public class Request {

    private List<String> requiredRoles;

    private String method;

    private String url;

    private List<String> requiredResources;


    public Request() {

    }

    public Request(String url, String method, List<String> requiredResources, List<String> requiredRoles) {
        this.requiredRoles = requiredRoles;
        this.method = method;
        this.requiredResources = requiredResources;
        this.url = url;
    }
}
