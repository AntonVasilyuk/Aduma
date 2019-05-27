package ru.job4j.convert_to_map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.school.Student;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;

/**.
 * Chapter_003
 * Task_110226
 * Test working convert list students to map
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class ConvertListToMapTest {

    /**.
     * @list is list for testing
     */
    private List<Student> list;

    /**.
     * Preparing for tests,
     * Load list students.
     */
    @Before
    public void loadStudents() {
        list = List.of(
            new Student(5, "Semenov")
            ,new Student(10, "Zaharov")
            ,new Student(15, "Razanov")
            ,new Student(15, "Razanov"));
    }

    /**.
     * Test converting list students to map where key is family and value is object students
     */
    @Test
    public void whenListStudentsThenConvertingToMapStudents() {
        ConvertListToMap converter = new ConvertListToMap();
        Map<String, Student> result = converter.convert(list);
        Assert.assertThat(result.get("Semenov").getScore(), is(5));
    }

    /**.
     * Test result converting to unique elements
     */
    @Test
    public void whenListStudentsThenConvertingToMapUnique() {
        ConvertListToMap converter = new ConvertListToMap();
        Map<String, Student> result = converter.convert(list);
        Assert.assertThat(result.size(), is(3));
    }
}