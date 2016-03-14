package edu.sample.jboss.resteasy.login;

import org.jboss.resteasy.annotations.Form;

import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * The sample of using {@link FormParam @FormParam} and {@link Form @Form} to bing REST request with data from form.
 * The samples of using {@link PathParam @PathParam}, {@link QueryParam @QueryParam}, {@link HeaderParam@HeaderParam},
 * {@link CookieParam @CookieParam} and {@link MatrixParam @MatrixParam}.
 * See more details in http://www.mastertheboss.com/jboss-frameworks/resteasy/resteasy-tutorial-part-two-web-parameters.
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

    @GET
    @Path("login/{authMethod}")
    @Produces("text/html")
    public String login(@PathParam("authMethod") String authenticationMethod,
                        @QueryParam("userName") @DefaultValue("") String userName,
                        @QueryParam("pass") @DefaultValue("") String password) {
        if (!"pass".equals(authenticationMethod)) {
            return "Authentication via '" + authenticationMethod + "' is not supported";
        }

        if (null == userName || "".equals(userName) || null == password || "".equals(password)) {
            return "You need to specify user name and password (user name: '" + userName
                + "', password: '" + password + "').";
        }

        return "Attempt to sign in by user: '" + userName + "', with password: '" + password + "'.";
    }

    @GET
    @Path("loginInfo")
    @Produces("text/html")
    public String loginInfo(@HeaderParam("User-Agent") String userAgent, @CookieParam("sessionid") String sessionId) {
        // http://citforum.ru/internet/html/cookie.shtml
        // use 'Cookie: sessionid=test' to send the cookie value to RESTful web service
        return "You use '" + userAgent + "' and your session id is '" + sessionId + "'.";
    }

    @GET
    @Path("loginMatrix")
    @Produces("text/html")
    public String loginViaMatrixParam(@MatrixParam("authMethod") String authenticationMethod,
                                      @MatrixParam("userName") String userName,
                                      @MatrixParam("pass") String password) {
        return login(authenticationMethod, userName, password);
    }

}
