package edu.sample.jboss.resteasy;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * The test for the {@link HelloWorld}.
 * Date: 03/09/2016
 *
 * @author Andrei_Khadziukou
 */
public class HelloWorldTest {

    HelloWorld helloWorld = new HelloWorld();

    @Test
    public void testHelloWorld() {
        Assert.assertEquals("Hello World!!!", helloWorld.helloWorld());
    }

    @Test
    @Ignore("We need additional dependency to run it")
    public void testHelloTo() {
        Assert.assertEquals("Hello, Andrei!", helloWorld.helloTo("Andrei").getEntity());
    }
}
