package com.gepardec.tdd.rest;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class UserEndpointTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(UserEndpoint.class);
    }

    @Test
    public void testUsers() {
        Response response = target("users").request().get();
    
        assertEquals("Http Response should be 200: ", Status.OK.getStatusCode(), response.getStatus());
        assertEquals("Http Content-Type should be: ", MediaType.TEXT_HTML, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
    
        String content = response.readEntity(String.class);
        assertEquals("Content of ressponse is: ", "ok", content);
    }
}
