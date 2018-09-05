package ru.job4j;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlWorks {

    /**.
     * Logger for class ControlWorks
     */
    private final static Logger log = LoggerFactory.getLogger(ControlWorks.class);

    /**.
     * Method main
     * @param args
     */
    public static void main(String[] args) {
        log.info("Programm start");
        int periodScanning = Integer.parseInt(Settings.getInstance().getValues("cron.time"));
        try {
            JobDetail job = JobBuilder.newJob(ParsingSite.class).withIdentity("parsingsite").build();
            Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.simpleSchedule().
                    withIntervalInHours(periodScanning).repeatForever()).build();
            SchedulerFactory schFactory = new StdSchedulerFactory();
            Scheduler scheduler = schFactory.getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        }catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }
}