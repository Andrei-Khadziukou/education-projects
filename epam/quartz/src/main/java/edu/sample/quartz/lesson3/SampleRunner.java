package edu.sample.quartz.lesson3;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.DirectSchedulerFactory;

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
        JobDetail job = newJob(HelloJob.class).withIdentity("helloJob", "group-lesson-3").build();

        Trigger trigger = newTrigger().withIdentity("helloJobTrigger", "group-lesson-3").startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(4).repeatForever()).build();

        DirectSchedulerFactory.getInstance().createVolatileScheduler(10);
        Scheduler scheduler = DirectSchedulerFactory.getInstance().getScheduler();
        scheduler.scheduleJob(job, trigger);

        scheduler.start();

        Thread.currentThread().sleep(4000L);
        scheduler.shutdown();

    }
}
