package at.gepardec.trainings.tdd.jersey.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("ping")
public class PingEndpoint {
    @GET
    public String ping() {
        return "pong";
    }
}