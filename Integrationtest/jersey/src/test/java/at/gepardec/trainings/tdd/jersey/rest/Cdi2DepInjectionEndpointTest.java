package at.gepardec.trainings.tdd.jersey.rest;

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

public class Cdi2DepInjectionEndpointTest extends JerseyTest {
    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        return new ResourceConfig()
            .registerClasses(DepInjectionEndpoint.class);
    }

    @Test
    public void testDi() {
        Response response = target("di").request().get();
    
        assertEquals(Status.OK.getStatusCode(), response.getStatus());
        assertEquals(MediaType.TEXT_HTML, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
    
        String content = response.readEntity(String.class);

        assertEquals("Factory: Dependency Injection", content);
    }
}
