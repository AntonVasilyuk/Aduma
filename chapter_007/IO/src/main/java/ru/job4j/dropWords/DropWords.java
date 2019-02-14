package ru.job4j.dropWords;

import java.io.*;

/**.
 * Chapter_007
 * Task 10.1.2.
 * Edit text in the input stream
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class DropWords {

    /**.
     * It's method for deleting words from text in stream
     * @param in is inputStream
     * @param out is outputStream
     * @param abuse is array words for deleting
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        String line = "";
        try(BufferedReader br = new BufferedReader(new InputStreamReader(in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < abuse.length; i++) {
                    System.out.println(abuse[i]);
                    line = line.replaceAll(abuse[i], "");
                    line = line.replaceAll("  ", " ");
                }
                System.out.println(line);
                writer.write(line);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
