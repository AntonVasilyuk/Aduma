package ru.job4j;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Task 7.4.2.
 * Create realisation ThreadPool
 *
 * @author Anton Vasilyuk on 10.08.2017.
 * @version 1.0.
 */
public class ThreadPool{

    /**.
     * @workQueue is queue for new task
     */
    private final Queue<Runnable> workQueue = new ConcurrentLinkedQueue<>();

    /**.
     * @MAXTHREAD is count thread
     */
    private static final int MAXTHREAD = Runtime.getRuntime().availableProcessors();

    /**.
     * @queueThreads is array for create thread
     */
    private Thread[] queueThreads = new Thread[MAXTHREAD];

    /**.
     * @lock for locking
     */
    private Object lock = new Object();

    /**.
     * Constructor for this class
     * @throws InterruptedException is may be exception
     */
    public ThreadPool() throws InterruptedException {
        for(int i = 0; i < MAXTHREAD; i++) {
            queueThreads[i] = new Thread(new TaskWorker());
            queueThreads[i].start();
        }
    }

    /**.
     * Method for adding new task
     * @param work is runnuble
     */
    public void add(Work work) {
        synchronized (lock) {
            this.workQueue.add(work);
            lock.notifyAll();
        }
    }

    /**.
     * Method for end working
     */
    public void shutdown() {
        while(!workQueue.isEmpty()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(Thread thread : queueThreads) {
            thread.interrupt();
        }
    }

    /**.
     * Class for create new thread
     */
    private final class TaskWorker extends Thread {

        @Override
        public void run() {
            Runnable thread;
            while(!isInterrupted()) {
                synchronized (lock) {
                    while (workQueue.isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                    thread = workQueue.poll();
                    try {
                        thread.run();
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**.
     * Method for printing count threads
     */
    public void printCountProcessor() {
        System.out.printf("Used %d threads.%n", MAXTHREAD);
    }
}
