package io.klib.aries.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.osgi.service.component.annotations.*;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;

@Component(
	    property = {
	        JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)",
	        JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true"
	    },
	    service = ExampleResource.class
	)
@JaxrsResource
public class ExampleResource {

    @GET
    @Path("/{name}")
    public String sayHello(@PathParam("name") String name) {
        return "Hello " + name;
    }

}