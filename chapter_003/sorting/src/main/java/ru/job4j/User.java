package ru.job4j;

/**.
 * Chapter_003
 * Task 3.3.1
 * Sortint array users by name
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class User implements Comparable<User> {

    /**.
     * @name user
     */
    private String name;

    /**.
     * @age user
     */
    private Integer age;

    /**.
     * Constructor user
     * @param name it's name to user
     * @param age it's age to user
     */
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**.
     * Getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**.
     * Getter for fiels age
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**.
     * Comparing users
     * @param o it's user for comparing
     * @return result
     */
    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.getAge());
    }
}
