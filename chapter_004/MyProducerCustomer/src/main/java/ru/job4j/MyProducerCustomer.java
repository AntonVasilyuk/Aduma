package ru.job4j;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Task 7.4.1.
 * Create realisation pattern Produser Consumer
 *
 * @author Anton Vasilyuk on 07.08.2017.
 * @version 1.0.
 */
public class MyProducerCustomer {

    /**.
     * This object for create monitor lock
     */
    private final Object lock = new Object();

    /**.
     * This array for list names
     */
    private String[] listNames;

    /**.
     * This blocking queue
     */
    private Queue<String> queue;

    /**.
     * @maxSize for max size this queue
     */
    private int maxSize;

    /**.
     * @thereMoreElements is value for checking for items
     */
    private boolean thereMoreElements;

    /**.
     * Constructor for this class
     * @param list this array for list names
     */
    public MyProducerCustomer(String[] list) {
        this.listNames = list;
        this.queue = new LinkedBlockingQueue();
        this.maxSize = list.length;
        this.thereMoreElements = true;
    }

    /**.
     * It is Thread Consumer
     * @return new Thread
     */
    public Thread consumer() {
        return new Thread(() -> {
            while (thereMoreElements) {
                consume();
            }
        });
    }

    /**.
     * It's method for consumer
     */
    private void consume() {
        synchronized (lock) {
            while (this.queue.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("Consumer take name: %s%n", queue.poll());
            lock.notify();
        }
    }

    /**.
     * It's Thread Producer
     * @return new Thread
     */
    public Thread producer() {
        return new Thread(() -> {
            for(int i = 0; i < maxSize; i++) {
                produce(listNames[i]);
            }
            this.thereMoreElements = false;
        });
    }

    /**.
     * It's method for Producer
     * @param text
     */
    public void produce(String text) {
        synchronized (lock) {
            while (queue.size() == maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(text);
            System.out.printf("Producer put to the queue: %s%n", text);
            lock.notify();
        }
    }
}
