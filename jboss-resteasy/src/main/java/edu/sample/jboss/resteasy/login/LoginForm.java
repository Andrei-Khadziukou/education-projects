package edu.sample.jboss.resteasy.login;

import javax.ws.rs.FormParam;

/**
 * The sample of using auto mapping between HTML form and the instance of this class.
 * From: http://www.mastertheboss.com/jboss-frameworks/resteasy/resteasy-tutorial-part-two-web-parameters
 * Date: 03/10/2016
 *
 * @author Andrei_Khadziukou
 */
public class LoginForm {
    @FormParam("userName")
    private String name;
    @FormParam("pass")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
