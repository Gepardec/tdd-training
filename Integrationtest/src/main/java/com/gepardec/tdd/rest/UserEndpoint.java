package com.gepardec.tdd.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gepardec.tdd.models.User;

@Path("users")
public class UserEndpoint {
    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") String id) {
        var usr = new User();
        usr.setId(id);
        usr.setUsername("Tester");

        return Response
            .ok(usr)
            .build();
    }
}