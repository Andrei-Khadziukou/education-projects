package edu.sample.jboss.resteasy.login;

import org.jboss.resteasy.annotations.Form;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * The sample of using {@link javax.ws.rs.FormParam @FormParam} to bing REST request with data from form. See more
 * details in http://www.mastertheboss.com/jboss-frameworks/resteasy/resteasy-tutorial-part-two-web-parameters
 * Date: 03/10/2016
 *
 * @author Andrei_Khadziukou
 */
@Path("")
public class LoginService {

    @POST
    @Path("login")
    @Produces("text/html")
    public String login(@FormParam("userName") String user, @FormParam("pass") String password) {
        return "Attempt to sign in by user: " + user + ", with password: " + password + ".";
    }

    @POST
    @Path("loginForm")
    @Produces("text/html")
    public String login(@Form LoginForm form) {
        return "Attempt to sign in by user: " + form.getName() + ", with password: " + form.getPassword() + ".";
    }

}
