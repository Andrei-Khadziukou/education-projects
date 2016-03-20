package com.spring_28min.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * The test for the {@link GoodbyeService}.
 *
 * @author Andrei Khadziukou
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class GoodbyeServiceTest {

    @Autowired
    private FarewellService goodbyeService;

    @Test
    public void testFarewell() throws Exception {
        Assert.assertEquals("Goodbye!", goodbyeService.farewell());
    }
}