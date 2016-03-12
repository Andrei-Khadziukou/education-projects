package com.spring_28min.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * The test for {@link GoodMorningService}
 *
 * Date: 12.03.2016.
 * @author Andrei Khadziukou
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class GoodMorningServiceTest {

    @Autowired
    private GoodMorningService goodMorningService;

    @Test
    public void testSayHi() throws Exception {
        assertNotNull(goodMorningService);
        assertEquals("Good Morning!", goodMorningService.sayHi());
    }
}