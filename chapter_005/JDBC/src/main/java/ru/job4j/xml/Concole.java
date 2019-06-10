package ru.job4j.xml;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Task 8.4.1.
 * Create for writing from console
 */
public class Concole {

    /**.
     * Link for writes
     */
    private Scanner input;

    /**.
     * Link for output
     */
    private PrintStream out;

    /**.
     * Constructor
     */
    public Concole() {
        input = new Scanner(System.in);
        out = System.out;
    }

    /**.
     * Method for ask count numbers
     * @param question is question
     * @return count number
     */
    public int ask(String question) {
        this.out.print(question);
        try {
        return (Integer.valueOf(input.nextLine()));
    } catch (NumberFormatException nfe) {
            this.out.println("Invalid input");
            return 0;
        }
    }
}
