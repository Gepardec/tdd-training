package at.gepardec.trainings.tdd.jersey.rest;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import at.gepardec.trainings.tdd.jersey.factories.StringFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Hk2DepInjectionEndpointTest extends JerseyTest {
    private static class Binder extends AbstractBinder {
        @Override
        protected void configure() {
            bind(StringFactory.class).to(StringFactory.class).ranked(1);
        }
    }

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        return new ResourceConfig()
            .registerClasses(DepInjectionEndpoint.class)
            .registerInstances(new Binder());
    }

    @Test
    public void testDi() {
        Response response = target("di").request().get();
        String content = response.readEntity(String.class);
    
        assertEquals(Status.OK.getStatusCode(), response.getStatus());
        assertEquals(MediaType.TEXT_HTML, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
        assertEquals("Factory: Dependency Injection", content);
    }
}
