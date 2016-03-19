package com.spring_28min.app;

import com.spring_28min.service.ApplicationContextConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * The test for {@link HelloWorldSampleRunner}.
 *
 * @author Andrei Khadziukou
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class HelloWorldSampleRunnerTest {

    @Autowired
    HelloWorldSampleRunner helloWorldSampleRunner;

    @Test
    public void testRunSample() throws Exception {
        helloWorldSampleRunner.runSample();
    }
}