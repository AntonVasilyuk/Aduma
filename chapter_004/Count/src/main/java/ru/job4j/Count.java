package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Task 7.3.1.
 * Create class Count for increment number
 *
 * @author Anton Vasilyuk on 26.07.2017.
 * @version 1.0.
 */
@ThreadSafe
public class Count {

    /**.
     * @lock the object for Monitor block
     */
    private final Object lock = new Object();

    /**.
     * The method for main action to the programm
     * @param theNumberThreads is count threads
     * @param number is first number
     * @throws InterruptedException may be exception
     */
    public int mainAction(int theNumberThreads, int number) throws InterruptedException {
        Action action = new Action(theNumberThreads, number);
        return action.action();
    }

    /**.
     * The Class for create action
     */
    public class Action {

        /**.
         * @numThreads is count created threads
         */
        private int numThreads;

        /**.
         * @number is first number
         */
        private final Number number;

        /**.
         * Constructor for this class
         * @param numThreads is count created threads
         * @param number is first number
         */
        public Action(int numThreads, int number) {
            this.numThreads = numThreads;
            this.number = new Number(number);
        }

        /**.
         * The method create more threads and increamet number in every thread
         * @throws InterruptedException is may be exception
         */
        public int action() throws InterruptedException {
            for(int i = 0; i < numThreads; i++) {
                Thread thread = new MyThread(number);
                thread.start();
                thread.join();
            }
            System.out.printf("Result increament is %d", number.getNum());
            return number.getNum();
        }
    }

    /**.
     * The class for create and storage number
     */
    public class Number {

        /**.
         * @num is number for action
         */
        @GuardedBy("lock")
        private int num;

        /**.
         * Constructor for this class
         * @param num is number for action
         */
        public Number(int num) {
            this.num = num;
        }

        /**.
         * Synchronized method for increament number
         */
        public void incremant() {
            synchronized (lock) {
                this.num += 1;
            }
        }

        /**.
         * Getter for variable number
         * @return number
         */
        public int getNum() {
            return this.num;
        }
    }

    /**.
     * The class for create my threads
     */
    public class MyThread extends Thread {

        /**.
         * @num is link to the instances class number
         */
        Number num;

        /**.
         * Constructor for this class
         * @param num
         */
        public MyThread(Number num) {
            this.num = num;
        }

        /**.
         * Realisation method run for my thread
         */
        @Override
        public void run() {
            num.incremant();
        }
    }
}
