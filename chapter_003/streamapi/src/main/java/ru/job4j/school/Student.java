package ru.job4j.school;

/**.
 * Chapter_003
 * Model student
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class Student {

    /**.
     * @score it's score this student
     */
    private final int score;

    /**.
     * Constructor
     * @param score it's score this student
     */
    public Student(int score) {
        this.score = score;
    }

    /**.
     * Getter for student
     * @return the score
     */
    public int getScore() {
        return score;
    }
}
