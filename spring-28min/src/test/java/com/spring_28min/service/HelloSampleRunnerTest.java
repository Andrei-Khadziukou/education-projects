package com.spring_28min.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * The test for {@link HelloSampleRunner}.
 *
 * Date: 12.03.2016.
 * @author Andrei Khadziukou
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class HelloSampleRunnerTest {

    @Autowired
    private HelloSampleRunner helloSampleRunner;

    @Test
    public void testSay() throws Exception {
        assertNotNull(helloSampleRunner);
        helloSampleRunner.say();
    }
}