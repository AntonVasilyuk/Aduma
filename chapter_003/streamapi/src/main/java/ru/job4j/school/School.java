package ru.job4j.school;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /**.
     * Method for selection of student by score
     * @param students is list students
     * @param bound is selection score
     * @return list selection students
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        List<Student> listRes = students.stream()
                .flatMap(Stream::ofNullable)
                .dropWhile(student -> student.getScore() < bound)
                .collect(Collectors.toList());
        return listRes;
    }
}
