package ru.job4j.dropwords;


import org.apache.log4j.Logger;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.stream.Collectors;

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
     * Logger
     */
    private static final Logger LOG = Logger.getLogger(DropWords.class.getName());

    /**.
     * It's method for deleting words from text in stream
     * @param in is inputStream
     * @param out is outputStream
     * @param abuse is array words for deleting
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        String line = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
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
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * It's method for deleting words from text in stream with stream api
     * @param in is inputStream
     * @param out is outputStream
     * @param abuse is array words for deleting
     */
    public void dropAbusesStreamAPI(InputStream in, OutputStream out, String[] abuse) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
        writer.write(reader.lines()
                .map(line -> {
                    for (String word : abuse) {
                        line = line.replaceAll(word, "");
                    }
                    return line.replaceAll("  ", " ");
                }).collect(Collectors.joining("\n")));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
