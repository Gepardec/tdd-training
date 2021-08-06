package at.gepardec.trainings.tdd.jersey.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import at.gepardec.trainings.tdd.jersey.factories.StringFactory;

@Path("di")
public class DepInjectionEndpoint {
    @Inject
    private StringFactory sf;

    @GET
    public String di() {
        return sf.getString("Dependency Injection");
    }
}