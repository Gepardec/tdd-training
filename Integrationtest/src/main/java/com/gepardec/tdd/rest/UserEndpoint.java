package com.gepardec.tdd.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("users")
public class UserEndpoint {
    @GET
    public String ok() {
        return "ok";
    }
}