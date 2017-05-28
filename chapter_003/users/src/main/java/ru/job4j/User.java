package ru.job4j;

/**.
 * Chapter_003
 * Task 3.2.2
 * Create collection HashMap
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class User {
    /**.
     * id is key
     */
    private Integer id;
    /**.
     * name is name user
     */
    private String name;
    /**.
     * city is city user
     */
    private String city;

    /**.
     *
     * @param id user
     * @param name user
     * @param city user
     */
    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**.
     * Getter for id
     * @return id
     */
    public Integer getId(){
        return this.id;
    }
    public String getName() {
        return this.name;
    }

    /**.
     * Method comparison users
     * @param obj
     * @return comparison users
     */
    @Override
    public boolean equals(Object obj) {
        User u = (User) obj;
        return getName().equals(u.getName());
    }

    /**.
     * Method comparison users
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return getName().hashCode();
    }

}
