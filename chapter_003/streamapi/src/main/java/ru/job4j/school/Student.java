package ru.job4j.school;

import java.util.Objects;

/**.
 * Chapter_003
 * Model student
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class Student implements Comparable<Student> {

    /**.
     * @score it's score this student
     */
    private final int score;

    /**.
     * @family is family the student
     */
    private String family;

    /**.
     * Constructor
     * @param score it's score this student
     * @param family it's family the student
     */
    public Student(int score, String family) {
        this.score = score;
        this.family = family;
    }

    /**.
     * Getter for student
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**.
     * Getter for family
     * @return family
     */
    public String getFamily() {
        return family;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(family, student.family);
    }

    @Override
    public int hashCode() {
        int result = 17;
        int con = 31;
        result = result * con + score;
        result = result * con + family.hashCode();
        return result;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.score, o.getScore());
    }
}
