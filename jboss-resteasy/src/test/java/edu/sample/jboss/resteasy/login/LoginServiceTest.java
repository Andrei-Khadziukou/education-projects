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

    @Test
    public void testLoginInfo() {
        Assert.assertEquals("You use 'Mazila Firexof' and your session id is '87483r57837458374'.",
            loginService.loginInfo("Mazila Firexof", "87483r57837458374"));
    }

    @Test
    public void testLoginWithPathAndQueryParams() {
        Assert.assertEquals("Attempt to sign in by user: 'Andrei', with password: 'pass1'.",
            loginService.login("pass", "Andrei", "pass1"));
    }

    @Test
    public void testLoginWithWrongPathParam() {
        Assert.assertEquals("Authentication via 'test' is not supported",
            loginService.loginViaMatrixParam("test", null, null));
    }

    @Test
    public void testLoginWithPathParamAndEmptyCredentials() {
        Assert.assertEquals("You need to specify user name and password (user name: 'Andrei', password: '').",
                loginService.login("pass", "Andrei", ""));
    }

    @Test
    public void testLoginWithMatrixParam() {
        Assert.assertEquals("Attempt to sign in by user: 'Andrei', with password: 'pass1'.",
            loginService.loginViaMatrixParam("pass", "Andrei", "pass1"));
    }

    @Test
    public void testLoginWithMatrixParamNoAuthenticationMethod() {
        Assert.assertEquals("Authentication via 'test' is not supported",
            loginService.loginViaMatrixParam("test", null, null));
    }

    @Test
    public void testLoginWithMatrixParamNoPassword() {
        Assert.assertEquals("You need to specify user name and password (user name: 'Andrei', password: '').",
            loginService.loginViaMatrixParam("pass", "Andrei", ""));
    }
}
