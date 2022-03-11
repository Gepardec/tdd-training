package at.gepardec.trainings.tdd.jersey.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import at.gepardec.trainings.tdd.jersey.models.User;
import at.gepardec.trainings.tdd.jersey.util.PATCH;

@Path("users")
public class UserEndpoint {
    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") String id) {
        try {
            var numId = Long.valueOf(id);

            // 13 is unlucky => we dont save something like that
            if(numId == 13L) {
                return Response
                    .status(Status.NOT_FOUND)
                    .build();
            }

            // Get User from DB
            var usr = new User(numId, "Tester");
            
            return Response
                .ok(usr)
                .build();
        } catch(NumberFormatException e) {
            return Response
                .status(Status.BAD_REQUEST)
                .build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putUser(User usr) {
        if(usr == null || usr.getUsername() == null) {
            return Response
                .status(Status.BAD_REQUEST)
                .build();
        }
        
        // Save to DB
        usr.setId(1L);
        
        return Response
            .ok(usr)
            .build();
    }

    @DELETE
    @Path("{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("userId") Long id) {
        return Response
            .ok(true)
            .build();
    }

    @PATCH
    @Path("{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response patchUser(@PathParam("userId") Long id, User usr) {
        if(id == null || usr == null) {
            return Response
                .status(Status.BAD_REQUEST)
                .build();
        }
        
        // Save to DB
        usr.setId(id);
        
        return Response
            .ok(usr)
            .build();
    }
}