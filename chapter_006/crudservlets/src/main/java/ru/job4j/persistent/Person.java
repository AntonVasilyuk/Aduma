package ru.job4j.persistent;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

/**.
 * Task 9.2.1.
 * Model for info about person
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */
public class Person implements Serializable {

    /**.
     * It's name for person
     */
    private String name;

    /**.
     * It's family for person
     */
    private String family;

    /**.
     * It's gender for person
     */
    private String sex;

    /**.
     * It's description for person
     */
    private String description;

    /**.
     * It's constructor for this class
     * @param name is name the person
     * @param family is family the person
     * @param sex is sex the person
     * @param description is description the person
     */
    @JsonPropertyOrder({"name", "family", "sex", "description"})
    public Person(String name, String family, String sex, String description) {
        this.name = name;
        this.family = family;
        this.sex = sex;
        this.description = description;
    }

    /**.
     * It's method for comparison persons
     * @param p it's other person
     * @return result boolean
     */
    public boolean checkPersons(Person p) {
        boolean result = false;
        if (this.name.equals(p.getName()) && this.family.equals(p.getFamily())) {
            result = true;
        }
        return result;
    }

    /**.
     * It's person for print
     * @return String reslisation for instace this class
     */
    @Override
    public String toString() {
        return String.format("%s %s %s %s", name, family, sex, description);
    }

    /**.
     * It's getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**.
     * It's setter for name
     * @param name is name for setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**.
     * It's getter for family
     * @return family
     */
    public String getFamily() {
        return family;
    }

    /**.
     * It's setter for family
     * @param family is family for setter
     */
    public void setFamily(String family) {
        this.family = family;
    }

    /**.
     * It's getter for sex
     * @return return gender for person
     */
    public String getSex() {
        return sex;
    }

    /**.
     * It's setter for sex
     * @param sex is sex for setter
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**.
     * It's getter for description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**.
     * it's setter for description
     * @param description is description for setter
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
