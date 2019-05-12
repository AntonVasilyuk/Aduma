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

/**.
 * Task 8.5.1.
 * Controll works apps
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */

public class ControlWorks {

    /**.
     * Logger for class ControlWorks
     */
    private static final Logger LOG = LoggerFactory.getLogger(ControlWorks.class);

    /**.
     * Method main
     * @param args is argumetns
     */
    public static void main(String[] args) {
        LOG.info("Programm start");
        int periodScanning = Integer.parseInt(Settings.getInstance().getValues("cron.time"));
        try {
            JobDetail job = JobBuilder.newJob(ParsingSite.class).withIdentity("parsingsite").build();
            Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.simpleSchedule().
                    withIntervalInHours(periodScanning).repeatForever()).build();
            SchedulerFactory schFactory = new StdSchedulerFactory();
            Scheduler scheduler = schFactory.getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}