package ru.job4j.tomap;

import ru.job4j.school.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**.
 * Chapter_003
 * Task_110226
 * Converting list to map, key is family and value is object student
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class ConvertListToMap {

    /**.
     * Method for converting list students to map, where key is family and value is student
     * @param listStudent is list student
     * @return converted map
     */
    public Map<String, Student> convert(List<Student> listStudent) {
        return listStudent.stream()
                .distinct()
                .collect(Collectors.toMap(k -> k.getFamily(), v -> v));
    }
}
