package edu.sample.quartz.common;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * The simple job to print "hello!".
 * Date: 05/27/2016
 *
 * @author Andrei_Khadziukou
 */
public class PrintHelloJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("hello!");
    }
}
