package edu.sample.jboss.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * The hello sample for the JBoss RESTEasy
 * (from the http://www.mastertheboss.com/jboss-frameworks/resteasy/resteasy-tutorial tutorial).
 * Date: 03/09/2016
 *
 * @author Andrei_Khadziukou
 */
@Path("/tutorial")
public class HelloWorld {

    @GET
    @Path("/helloworld")
    public String helloWorld() {
        // localhost:8080/jboss-resteasy-1.0-SNAPSHOT/rest/tutorial/helloworld
        return "Hello World!!!";
    }

    @GET
    @Path("helloworld/{name}")
    public Response helloTo(@PathParam("name") String name) {
        // response generated based on http://buraktas.com/resteasy-example-without-using-a-web-xml/ sample
        return Response.status(Response.Status.OK).entity("Hello, " + name + "!").build();
    }
}
