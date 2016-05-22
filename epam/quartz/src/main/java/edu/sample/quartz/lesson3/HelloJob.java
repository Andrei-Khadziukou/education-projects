package edu.sample.quartz.lesson3;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * The hello job.
 *
 * @author Andrei Khadziukou
 */
public class HelloJob implements Job {
    // ramification is that it does not make sense to have state data-fields defined on the job class - as their values
    // would not be preserved between job executions

    public HelloJob() {
        // One of the ramifications of this behavior is the fact that jobs must have a no-argument constructor
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello! HelloJob is here!");
    }
}
