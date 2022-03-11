package at.gepardec.trainings.tdd.jersey.rest;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import at.gepardec.trainings.tdd.jersey.models.User;

/** 
 * Get the following tests to run, without changing the code of {@link UserEndpoint}
 */

@SuppressWarnings({"all"})
public class UserEndpointTest extends JerseyTest {

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(); //TODO: fill the ResourceConfig
    }

    
    /** 
     * When calling {@link UserEndpoint#getUser()} with an ID, 
     * the method should return a User with the given ID
     */
    @Test
    public void getUser_works() {
        final Response response = null; //TODO: write the request
        final User content = response.readEntity(User.class);
    
        assertEquals(Status.OK.getStatusCode(), response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
        assertNotNull(content);
        assertEquals(1L, content.getId());
    }

    /** 
     * When calling {@link UserEndpoint#getUser()} with an invalid non-number ID, 
     * the method should return a Response of BAD_REQUEST
     */
    @Test
    public void getUser_badRequest() {
        final Response response = null; //TODO: write the request
        final User content = response.readEntity(User.class);
    
        assertEquals(Status.BAD_REQUEST.getStatusCode(), response.getStatus());
        assertNull(content);
    }

    /** 
     * When calling {@link UserEndpoint#getUser()} with an unlucky ID of 13,
     * the method should return a Response of NOT_FOUND
     */
    @Test
    public void getUser_notFound() {
        final Response response = null; //TODO: write the request
        final User content = response.readEntity(User.class);
    
        assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
        assertNull(content);
    }

    /** 
     * When calling {@link UserEndpoint#putUser()} with a valid user,
     * the method should return a Response with the user plus an ID
     */
    @Test
    public void putUser() {
        final Response response = null; //TODO: write the request + entity
        final User content = response.readEntity(User.class);
    
        assertEquals(Status.OK.getStatusCode(), response.getStatus());
        assertNotNull(content);
        assertNotNull(content.getId());
        assertEquals("Test", content.getUsername());
    }

    /** 
     * When calling {@link UserEndpoint#putUser()} with an invalid user,
     * the method should return a Response of BAD_REQUEST
     */
    @Test
    public void putUser_badRequest() {
        final Response response = null; //TODO: write the request + entity
        assertEquals(Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    /** 
     * When calling {@link UserEndpoint#deleteUser()} with a valid ID,
     * the method should return a Response containing true
     */
    @Test
    public void deleteUser() {
        final Response response = null; //TODO: write the request + entity
        boolean content = response.readEntity(Boolean.class);
    
        assertEquals(Status.OK.getStatusCode(), response.getStatus());
        assertTrue(content);
    }

    /**
     * Sadly PATCH doesn't work with Jersey.<br/><br/>
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
        try {
            ; //TODO: write the request + entity
            fail("Request succeeded");
        } catch(ProcessingException e) {
            assertEquals("java.net.ProtocolException: Invalid HTTP method: PATCH", e.getMessage());
        }

    }
}
