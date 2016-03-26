package com.spring_28min.app;

import com.spring_28min.service.ApplicationContextConfiguration;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * The test for the {@link JdbcSampleRunner}.
 *
 * @author Andrei Khadziukou
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class JdbcSampleRunnerTest {

    @Autowired
    private JdbcSampleRunner jdbcSampleRunner;

    @BeforeClass
    public static void setUpClass() throws Exception {
        JdbcSampleRunner.startDbServer();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        JdbcSampleRunner.stopDbServer();
    }

    @Test
    public void testRunSample() {
        jdbcSampleRunner.runSample();
    }
}