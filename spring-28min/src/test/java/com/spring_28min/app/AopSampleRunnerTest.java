package com.spring_28min.app;

import com.spring_28min.service.ApplicationContextConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * The test for the {@link AopSampleRunner}.
 *
 * @author Andrei Khadziukou
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class AopSampleRunnerTest {

    @Autowired
    private AopSampleRunner aopSampleRunner;

    @Test
    public void testRunSample() {
        aopSampleRunner.runSample();
    }
}