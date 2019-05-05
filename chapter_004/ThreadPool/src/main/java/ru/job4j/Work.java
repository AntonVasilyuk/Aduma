package ru.job4j;

/**
 * Task 7.4.2.
 * Create realisation ThreadPool
 *
 * @author Anton Vasilyuk on 10.08.2017.
 * @version 1.0.
 */

public class Work implements Runnable {

    /**.
     * @index is index
     */
    private int index;

    /**.
     * Constructor
     * @param index is index
     */
    public Work(int index) {
        this.index = index;
    }

    /**.
     * Method run for thread
     */
    @Override
    public void run() {
        System.out.printf("Start work thread number %d%n", this.index);
    }
}
