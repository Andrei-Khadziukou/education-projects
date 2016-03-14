package edu.sample.jboss.resteasy.login;

import org.junit.Assert;
import org.junit.Test;

/**
 * The test for {@link LoginService}.
 * Date: 03/14/2016
 *
 * @author Andrei_Khadziukou
 */
public class LoginServiceTest {

    LoginService loginService = new LoginService();

    @Test
    public void testLogin() {
        Assert.assertEquals("Attempt to sign in by user: Andrei, with password: pass1.",
            loginService.login("Andrei", "pass1"));
    }

    @Test
    public void testLoginWithConvertingToLoginForm() {
        LoginForm loginForm = new LoginForm();
        loginForm.setName("Andrei");
        loginForm.setPassword("pass1");
        Assert.assertEquals("Attempt to sign in by user: Andrei, with password: pass1.", loginService.login(loginForm));
    }
}
