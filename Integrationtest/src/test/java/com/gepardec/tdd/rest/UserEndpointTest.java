package com.gepardec.tdd.rest;
import com.gepardec.tdd.models.User;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserEndpointTest extends JerseyTest {
    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(UserEndpoint.class, User.class);
    }

    @Test
    public void testUsers() {
        final Response response = target("users")
            .path("123")
            .request()
            .get();
    
    
        assertEquals(response.getStatus(), Status.OK.getStatusCode());
        assertEquals(response.getHeaderString(HttpHeaders.CONTENT_TYPE), MediaType.APPLICATION_JSON);
    
        User content = response.readEntity(User.class);

        assertNotNull(content);
        assertEquals(content.getId(), "123");
    }
}
