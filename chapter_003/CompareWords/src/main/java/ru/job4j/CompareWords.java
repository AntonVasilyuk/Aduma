package ru.job4j;

import com.sun.org.apache.bcel.internal.classfile.SourceFile;

import java.util.HashSet;

/**.
 * Task 5.7.3.
 * Create code for compare words
 *
 * @author Anton Vasilyuk on 15.10.2017
 * @version 1.0.
 */

public class CompareWords {

    /**.
     * @timeStart is time for start operation
     */
    private long timeStart;

    /**.
     * @timeEnd is time for end operation
     */
    private long timeEnd;

    /**.
     * @timeWork is total time
     */
    private long timeWork;

    /**.
     * @lengthOne is long for first word
     */
    private int lengthOne;

    /**.
     * @lengthOne is long for second word
     */
    private int lengthTwo;

    /**.
     * @hashOne is number for comparison with the second
     */
    private int hashOne;

    /**.
     * @hashTwo is number for comparison with the first
     */
    private int hashTwo;

    /**.
     * @oneCollection is one Collection
     */
    private HashSet<Character> oneColletcion;

    /**.
     * @twoCollection is two collection
     */
    private HashSet<Character> twoColletcion;


    /**.
     * Constructor for this class
     */
    public CompareWords() {
        hashOne = 0;
        hashTwo = 0;
        oneColletcion = new HashSet<>();
        twoColletcion = new HashSet<>();
    }

    /**.
     * Method for comparison words whithout collections
     * @param one is first word
     * @param two is second word
     * @return boolean
     */
    public boolean compareWordsOne(String one, String two) {
        lengthOne = one.length();
        lengthTwo = two.length();
        boolean result = false;

        if (lengthOne != lengthTwo) {return false;}
        timeStart = System.currentTimeMillis();
        char[] oneArray = one.toCharArray();
        char[] twoArray = two.toCharArray();
        for(int i = 0; i < lengthOne; i++) {
            hashOne = hashOne + (int)oneArray[i];
            hashTwo = hashTwo + (int)twoArray[i];
        }
        if (hashOne == hashTwo) {
            result = true;
        }
        timeEnd = System.currentTimeMillis();
        timeWork = timeEnd - timeStart;
        System.out.printf("%d milisec", timeWork);
        return result;
    }

    /**.
     * Method for comparison words with collection
     * @param one is first word
     * @param two is second word
     * @return boolean
     */
    public boolean compareWordsTwo(String one, String two) {
        lengthOne = one.length();
        lengthTwo = two.length();
        boolean result = false;

        timeStart = System.currentTimeMillis();
        char[] oneArray = one.toCharArray();
        char[] twoArray = two.toCharArray();
        for(int i = 0; i < lengthOne; i++) {
            oneColletcion.add((Character) oneArray[i]);
        }
        for(int i = 0; i < lengthTwo; i++) {
            twoColletcion.add((Character) twoArray[i]);
        }
        if (lengthOne > lengthTwo) {
            result = oneColletcion.containsAll(twoColletcion);
        } else {
            result = twoColletcion.containsAll(oneColletcion);
        }
        timeEnd = System.currentTimeMillis();
        timeWork = timeEnd - timeStart;
        System.out.printf("%d milisec%n", timeWork);
        return result;
    }
}
