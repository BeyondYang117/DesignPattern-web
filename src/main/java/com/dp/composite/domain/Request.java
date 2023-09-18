package com.dp.composite.domain;

import lombok.Data;

import java.util.List;

@Data
public class Request {


    private String url;

    private String method;

    private List<String> requiredResources;

    private List<String> requiredRoles;

    public Request() {

    }

    public Request(String url, String method, List<String> requiredResources, List<String> requiredRoles) {
        this.url = url;
        this.method = method;
        this.requiredResources = requiredResources;
        this.requiredRoles = requiredRoles;
    }
}
