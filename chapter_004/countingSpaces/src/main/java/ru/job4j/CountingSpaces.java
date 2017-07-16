package ru.job4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Task 7.1.1
 * Create aplication for counting spaces and word, use other threads
 *
 * @author Anton Vasilyuk on 16.07.2017.
 * @version 1.0
 * @since 0.1
 */
public class CountingSpaces {

    /**.
     * @numSpace is count space
     */
    private int numSpace = 0;

    /**.
     * @numWord is count word
     */
    private int numWord = 0;

    /**.
     * @arrayLength is count char in the string message
     */
    private int arrayLength;

    /**.
     * @space is space
     */
    private char space = ' ';

    /**.
     * @tempChar is array the char
     */
    private char[] tempChar;

    /**.
     * Method for calculation count spaces and words
     * @param msg is text for method
     * @return count spaces and words
     * @throws InterruptedException is may be exeption
     */
    public String parseToSpacesAndWords(String msg) throws InterruptedException {

        tempChar = msg.toCharArray();
        arrayLength = tempChar.length;

        System.out.printf("Hello, my aplication will start to work now!%n");
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(() -> {

            System.out.printf("Count spaces started%n");
            for (int i = 0; i < arrayLength; i++) {
                if (tempChar[i] == space) {
                    numSpace++;
                    System.out.printf("Count spaces increased is : %d%n", numSpace);
                }
            }
            System.out.printf("Thread count space is finished, and count space is %d%n", numSpace);
        });

        executor.execute(() -> {

            System.out.printf("Count words started%n");
            int num = 0;
            for (int i = 0; i < arrayLength; i++) {
                if (tempChar[i] == space) {
                    numWord++;
                    System.out.printf("Count words increased is : %d%n", numWord);
                    num = i;
                }
            }
            if (num != (arrayLength - 1) && tempChar[arrayLength - 1] != space) {
                numWord++;
            }
            System.out.printf("Thread count word is finished, and count word is %d%n", numWord);

        });

        while (executor.awaitTermination(1, TimeUnit.SECONDS)) {
            executor.shutdown();
        }
        System.out.printf("Finish all calculation!");
        return numSpace + " and " + numWord;
    }
}