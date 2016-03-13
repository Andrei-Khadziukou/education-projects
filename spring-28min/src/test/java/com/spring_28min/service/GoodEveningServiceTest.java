package com.spring_28min.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * The test for {@link GoodEveningService}.
 *
 * Date: 13.03.2016.
 * @author Andrei Khadziukou
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class GoodEveningServiceTest {

    @Autowired
    @Qualifier("goodEveningService")
    private HiService service;

    @Test
    public void testSayHi() throws Exception {
        assertEquals("Good Evening!", service.sayHi());
    }
}