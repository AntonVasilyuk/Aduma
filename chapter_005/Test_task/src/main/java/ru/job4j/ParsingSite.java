package ru.job4j;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParsingSite implements Job {

    /**.
     * it's logger for class ParsingSite
     */
    private final static Logger log = LoggerFactory.getLogger(ParsingSite.class);

    /**.
     * Link to the this object
     */
    private ConnectionWeb connectionWeb;

    /**.
     * Method for start parsing
     * @param jobExecutionContext
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("Run the scan site...");
        if (connectionWeb == null) {
            connectionWeb = new ConnectionWeb();
        }
        connectionWeb.getDataWebSite();
    }
}
