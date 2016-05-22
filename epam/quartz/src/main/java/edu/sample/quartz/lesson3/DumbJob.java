package edu.sample.quartz.lesson3;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import java.util.List;

/**
 * Dumb job.
 *
 * @author Andrei Khadziukou
 */
public class DumbJob implements Job {

    private List<Integer> callCounts;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        //JobDataMap can be used to hold any amount of (serializable) data objects which you wish to have
        // made available to the job instance when it executes
        JobKey key = context.getJobDetail().getKey();
        // it can lead to class-versioning problems, if some one update class the instance of which your program stored
        // in database (put JDBC-JobStore and JobDataMap into a mode where only primitives and strings are allowed to
        // be stored)
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");
        callCounts.add(1);

        System.out.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);
        System.out.println("Call count: " + callCounts);
    }

    // TODO check why it doesb't work with integer
    public void setCallCounts(List<Integer> callCounts) {
        this.callCounts = callCounts;
    }
}
