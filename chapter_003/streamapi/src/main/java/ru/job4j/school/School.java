package ru.job4j.school;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**.
 * Chapter_003
 * Storage and sorting students by score
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class School {

    /**.
     * Method for filtration students
     * @param students it's list students
     * @param predict it's operation for filtration
     * @return filtered list students
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(student -> predict.test(student)).collect(Collectors.toList());
    }
}
