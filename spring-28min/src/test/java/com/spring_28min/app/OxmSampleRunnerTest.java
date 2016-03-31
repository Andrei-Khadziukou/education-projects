package com.spring_28min.app;

import com.spring_28min.service.ApplicationContextConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * The test for {@link OxmSampleRunner}.
 *
 * @author Andrei Khadziukou
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class OxmSampleRunnerTest {

    @Autowired
    private OxmSampleRunner oxmSampleRunner;

    @Test
    public void testRunSample() throws IOException {
        oxmSampleRunner.runSample();
    }
}