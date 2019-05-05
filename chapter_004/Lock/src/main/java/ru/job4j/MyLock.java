package ru.job4j;

/**.
 * Task 7.4.3.
 * Create my realisation lock
 *
 * @author Anton Vasilyuk on 13.08.2017
 * @version 1.0.
 */
public class MyLock {

    /**.
     * @marker is marker for checking to locking
     */
    private boolean marker;

    /**.
     * Constructor for class MyLock
     */
    public MyLock() {
        this.marker = true;
    }

    /**.
     * Method for install status locking
     */
    public void lock() {
        synchronized (this) {
            while (marker) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.marker = true;
        }
    }

    /**.
     * Method for install status to unlocking
     */
    public void unlock() {
        synchronized (this) {
            notifyAll();
            this.marker = false;
        }
    }
}
