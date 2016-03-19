package com.spring_28min.xml_config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * The test for {@link HelloWorldGreeter}.
 *
 * @author Andrei Khadziukou
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/com/spring_28min/spring-config.xml") // there is enough to use only the XML configuration
public class HelloWorldGreeterTest {

    @Autowired
    private HelloWorldGreeter helloWorldGreeter;

    @Test
    public void testGreetWorld() throws Exception {
        Assert.assertEquals("Hello, World!", helloWorldGreeter.greetWorld());
    }
}