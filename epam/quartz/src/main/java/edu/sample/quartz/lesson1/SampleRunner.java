package edu.sample.quartz.lesson1;

import edu.sample.quartz.common.PrintHelloJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * The runner of the sample.
 * Date: 05/27/2016
 *
 * @author Andrei_Khadziukou
 */
public class SampleRunner {

    public static void main(String[] args) {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        try {
            Scheduler scheduler = schedulerFactory.getScheduler();

            JobDetail printHelloJobDetail = JobBuilder.newJob(PrintHelloJob.class)
                    .withIdentity("printHelloJobKey", "lesson-1").build();

            Trigger printHelloJobTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("printHelloJobTriggerKey", "lesson-1").startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(4).repeatForever())
                    .build();

            scheduler.scheduleJob(printHelloJobDetail, printHelloJobTrigger);
            scheduler.start();

            Thread.sleep(60000L);

            scheduler.shutdown();
        } catch (SchedulerException | InterruptedException e) {
            System.err.println(e.getMessage());
        }

    }
}
