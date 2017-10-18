package ru.job4j;

import com.sun.org.apache.bcel.internal.classfile.SourceFile;

import java.util.*;

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
    private Map<Character, Integer> oneColletcion;

    /**.
     * @twoCollection is two collection
     */
    private Map<Character, Integer> twoColletcion;

    Character temp;

    /**.
     * Constructor for this class
     */
    public CompareWords() {
        hashOne = 0;
        hashTwo = 0;
        oneColletcion = new HashMap<>();
        twoColletcion = new HashMap<>();
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
        boolean result = true;

        timeStart = System.currentTimeMillis();
        char[] oneArray = one.toCharArray();
        char[] twoArray = two.toCharArray();
        for(int i = 0; i < lengthOne; i++) {
            Character key = oneArray[i];
            oneColletcion.putIfAbsent(key, 1);
            oneColletcion.computeIfPresent(key, (k, v) -> {
                v = v + 1;
                return v;
            });
        }
        for(int i = 0; i < lengthTwo; i++) {
            Character key = twoArray[i];
            twoColletcion.putIfAbsent(key, 1);
            twoColletcion.computeIfPresent(key, (k, v) -> {
                v = v + 1;
                return v;
            });
        }

        Set<Character> keys = oneColletcion.keySet();
        Iterator<Character> iter = keys.iterator();
        for (int i = 0; i < lengthOne; i++) {
            if (iter.hasNext()) {
                temp = iter.next();
                if (!oneColletcion.get(temp).equals(twoColletcion.get(temp))) {result = false;}
            }
        }
        timeEnd = System.currentTimeMillis();
        timeWork = timeEnd - timeStart;
        System.out.printf("%d milisec%n", timeWork);
        return result;
    }
}
