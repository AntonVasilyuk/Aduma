package ru.job4j;

/**.
 * Task 7.2.1.
 * Create programm for visible problem to the JMM
 *
 * @author Anton Vasilyuk on 19.07.2017.
 * @version 1.0.
 * @since 0.1.
 */
public class CheckProblem {

    /**.
     * Method for create some number thread
     * @param one is number create
     * @return result calculate
     */
    public int checkProblem(int one) {
        Summ summ = new Summ();
        for (int i = 0; i < one; i++) {
            MyTread myTread = new MyTread(summ);
            myTread.start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printResult(summ.getCount());

        return summ.getCount();
    }

    /**.
     * Method for out result to the console
     * @param value for printing
     */
    public void printResult(int value) {
        System.out.printf("Value is %d%n", value);
    }

    /**.
     * Class over which the calculation is done
     */
    class Summ {

        /**.
         * @count is number for calculating
         */
        private int count = 0;

        /**.
         * Is method for calculating
         */
        public void summCount() {
            this.count++;
        }

        /**.
         * Method for get result
         * @return result
         */
        public int getCount() {
            return this.count;
        }
    }

    /**.
     * This class for create new thread
     */
    class MyTread extends Thread {

        /**.
         * @summ is link to the class Summ
         */
        private Summ summ;

        /**.
         * Constructor for this class
         * @param summ is link to the object summ
         */
        private MyTread(Summ summ) {
            this.summ = summ;
        }

        /**.
         * Method for calculation
         */
        @Override
        public void run() {
            for (int i = 0; i < 500; i++) {
                summ.summCount();
            }
        }
    }
}
