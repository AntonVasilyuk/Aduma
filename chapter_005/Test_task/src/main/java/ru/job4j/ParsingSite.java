package ru.job4j;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**.
 * Task 8.5.1.
 * Connect to a database to record found data
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */
public class ParsingSite implements Job {

    /**.
     * it's logger for class ParsingSite
     */
    private static final Logger LOG = LoggerFactory.getLogger(ParsingSite.class);

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
        LOG.info("Run the scan site...");
        if (connectionWeb == null) {
            connectionWeb = new ConnectionWeb();
        }
        connectionWeb.getDataWebSite();
    }
}
