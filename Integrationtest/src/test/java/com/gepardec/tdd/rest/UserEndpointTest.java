package com.gepardec.tdd.rest;
import com.gepardec.tdd.models.User;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserEndpointTest extends JerseyTest {
    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(UserEndpoint.class);
    }

    @Test
    public void getUser_works() {
        final Response response = target("users")
            .path("1")
            .request()
            .get();
    
    
        assertEquals(Status.OK.getStatusCode(), response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
    
        User content = response.readEntity(User.class);

        assertNotNull(content);
        assertEquals(1L, content.getId());
    }

    @Test
    public void getUser_badRequest() {
        final Response response = target("users")
            .path("someString")
            .request()
            .get();
    
    
        assertEquals(Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    
        User content = response.readEntity(User.class);

        assertNull(content);
    }

    @Test
    public void getUser_notFound() {
        final Response response = target("users")
            .path("13")
            .request()
            .get();
    
        assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
    
        User content = response.readEntity(User.class);

        assertNull(content);
    }

    @Test
    public void putUser() {
        var usr = new User("Test");
        var entity = Entity.entity(usr, MediaType.APPLICATION_JSON);

        final Response response = target("users")
            .request()
            .put(entity);
    
        assertEquals(Status.OK.getStatusCode(), response.getStatus());
    
        User content = response.readEntity(User.class);

        assertNotNull(content);
        assertNotNull(content.getId());
        assertEquals("Test", content.getUsername());
    }

    @Test
    public void putUser_badRequest() {
        var usr = new User();
        var entity = Entity.entity(usr, MediaType.APPLICATION_JSON);

        final Response response = target("users")
            .request()
            .put(entity);
    
        assertEquals(Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    public void deleteUser() {
        final Response response = target("users")
            .path("1")
            .request()
            .method("DELETE");
    
        assertEquals(Status.OK.getStatusCode(), response.getStatus());

        boolean content = response.readEntity(Boolean.class);

        assertTrue(content);
    }

    /**
     * Sadly PATCH doesnt work with Jersey.<br/><br/>
     * 
     * To try out that the request actually works, deploy it and fire the following HTTP Request:
     * 
     * <pre>
     * PATCH http://127.0.0.1:8080/it/rest/users/1
     * Content-Type: application/json
     *
     * {
     *    "username": "Test"
     * }
     * </pre>
     */
    @Test
    public void patchUser_fail() {
        var usr = new User("Test");
        var entity = Entity.entity(usr, MediaType.APPLICATION_JSON);

        try {
            target("users")
                .path("1")
                .request()
                .method("PATCH", entity);
        } catch(ProcessingException e) {
            assertEquals("java.net.ProtocolException: Invalid HTTP method: PATCH", e.getMessage());
        }

    }
}
