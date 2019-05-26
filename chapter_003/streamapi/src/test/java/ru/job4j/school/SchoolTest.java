package ru.job4j.school;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;

/**.
 * Chapter_003
 * Test working class School,
 * sorting list student by their score.
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class SchoolTest {

    /**.
     * Testing method collect
     */
    @Test
    public void whenCollectingNineStudentThenReturnThreeClassByThreeStudents() {
        List<Student> list = new ArrayList<>();
        School school = new School();
        for (int score = 30; score < 90; score += 20) {
            list.add(new Student(score + 5, "Semenov"));
            list.add(new Student(score + 10, "Zaharov"));
            list.add(new Student(score + 15, "Razanov"));
        }
        List<Student> classA = school.collect(list, x -> x.getScore() > 0 && x.getScore() < 50);
        List<Student> classB = school.collect(list, x -> x.getScore() >= 50 && x.getScore() < 70);
        List<Student> classC = school.collect(list, x -> x.getScore() >= 70 && x.getScore() <= 100);
        boolean result = false;
        if(classA.size() == 3 && classB.size() == 3 && classC.size() == 3) {
            result = true;
        }
        Assert.assertTrue(result);
    }

    /**.
     * Test working method selection students by score
     */
    @Test
    public void whenFiveStudentsThenGetThreeStudensWithScoreBetterBound() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(50, "Veselov"));
        students.add(new Student(55, "Solvov"));
        students.add(new Student(60, "Usov"));
        students.add(new Student(65, "Lovchiq"));
        students.add(new Student(70, "Volkov"));
        List<Student> result = new School().levelOf(students, 57);
        Assert.assertThat(result.size(), is(3));
    }
}