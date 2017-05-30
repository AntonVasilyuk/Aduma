package ru.job4j;

/**
 * Chapter_003
 * Task 3.3.1
 * Sortint array users by name
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class User implements Comparable<User>{

    /**.
     * @name user
     */
    private String name;

    /**.
     * @age user
     */
    private String age;

    /**.
     * Constructor user
     * @param name
     * @param age
     */
    public User(String name, String age) {
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

    public String getAge() {
        return age;
    }

    @Override
    public int compareTo (User o) {
        return this.age.compareTo(o.getAge());
    }
}
