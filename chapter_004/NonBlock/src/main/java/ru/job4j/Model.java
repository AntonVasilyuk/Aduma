package ru.job4j;

/**.
 * Task 7.5.1.
 * Create my realisation non blocking cash
 *
 * @author Anton Vasilyuk on 31.08.2017
 * @version 1.0.
 */

public class Model {

    /**.
     * @name is name for the model
     */
    private String name;

    /**.
     * @version is version for the model
     */
    private volatile int version = 0;

    /**.
     * Is constructor for this class
     * @param name is name
     */
    public Model(String name) {
        this.name = name;
    }

    /**.
     * Getter for this version
     * @return the version
     */
    public int getVersion() {
        return this.version;
    }

    /**.
     * Method for updating the version
     */
    public void updateVersion() {
        this.version++;
    }

    /**.
     * Getter for name of the model
     * @return name
     */
    public String getName() {return this.name;}
}
