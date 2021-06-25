package com.gepardec.tdd.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.gepardec.tdd.factories.StringFactory;

@Path("di")
public class DepInjectionEndpoint {
    @Inject
    private StringFactory sf;

    @GET
    public String di() {
        return sf.getString("Dependency Injection");
    }
}