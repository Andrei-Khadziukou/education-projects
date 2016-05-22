package edu.sample.quartz.lesson3;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.core.jmx.JobDataMapSupport;
import org.quartz.impl.DirectSchedulerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * The entry point to run samples.
 *
 * @author Andrei Khadziukou
 */
public class SampleRunner {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        JobDetail helloJobDetail = newJob(HelloJob.class).withIdentity("helloJob", "group-lesson-3").build();

        Trigger helloJobTrigger = newTrigger().withIdentity("helloJobTrigger", "group-lesson-3").startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();

        JobDetail dumbJobDetail = newJob(DumbJob.class).withIdentity("dumbJob", "group-lesson-3")
                /*
                JobDataMap can be used to hold any amount of (serializable) data objects which you wish
                to have made available to the job instance when it executes
                 */
                .usingJobData("jobSays", "Hello World!")
                .usingJobData("myFloatValue", 3.141f).build();

        Map<String, Object> map = new HashMap<>();
        map.put("callCounts", new ArrayList<Integer>());
        JobDataMap jobDataMap = JobDataMapSupport.newJobDataMap(map);

        Trigger dumbJobTrigger = newTrigger().withIdentity("dumbJobTrigger", "group-lesson-3").startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .usingJobData(jobDataMap).build();

        DirectSchedulerFactory.getInstance().createVolatileScheduler(10);
        Scheduler scheduler = DirectSchedulerFactory.getInstance().getScheduler();
        scheduler.scheduleJob(helloJobDetail, helloJobTrigger);
        scheduler.scheduleJob(dumbJobDetail, dumbJobTrigger);

        scheduler.start();

        Thread.sleep(4000L);
        scheduler.shutdown();

    }
}
