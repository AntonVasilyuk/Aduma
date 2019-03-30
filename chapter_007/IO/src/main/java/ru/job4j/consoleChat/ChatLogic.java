package ru.job4j.consoleChat;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Class working console chat.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 11.03.2019
 */

public class ChatLogic {

    /**.
     * It's link for this class
     */
    private static final ChatLogic logic = new ChatLogic();

    /**.
     * It's logger for this class
     */
    public static final Logger LOG = Logger.getLogger(ChatLogic.class.getName());

    /**.
     * It's marker for control working
     */
    private boolean working = true;

    /**.
     * It's marker for exiting
     */
    private boolean exit = false;

    /**.
     * Text for pause
     */
    private String pause = "Chat paused";

    /**.
     * Text for resume
     */
    private String resume = "Chat resumed, i am at your service";

    /**.
     * Start working chat
     */
    public void startChat() {
        Scanner scanner = new Scanner(System.in);
        greeting();
        String line;
        String answer;
        var chatLog = new File("chatLog.txt");

        try(var log = new FileWriter(chatLog)) {
            while (!exit) {
                line = scanner.nextLine();
                log.write(String.format("%s_ChatLog - user writing: %s", new Date().toString(), line));
                checkStatus(line);
                if (!exit) {
                    if (working) {
                        answer = getPhrase();
                        System.out.println(answer);
                        log.write(String.format("%s_ChatLog - server answering: %s", new Date().toString(), answer));
                    }
                }
                log.flush();
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**.
     * Method for getting random phrases
     * @return phrase
     */
    private String getPhrase() {
        String phrase = null;
        List<String> lines = null;
        try {
            lines = Files.lines(Paths.get(ChatLogic.class.getClassLoader().getResource("phrases.txt").getPath())).collect(Collectors.toList());
            int size = lines.size();
            int line = (int) Math.abs((Math.round(Math.random() * size) - 1));
            phrase = lines.get(line);

        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return phrase;
    }

    /**.
     * Check answer on command
     * @param command
     */
    private void checkStatus(String command) {
        String checkStat = command.toLowerCase();
        if (checkStat.equals("pause")) {
            working = false;
            System.out.println(pause);
        }
        if (checkStat.equals("resume")) {
            working = true;
            System.out.println(resume);
        }
        if (checkStat.equals("stop")) {
            exit = true;
            System.out.println("Chat is stoped");
        }
    }

    /**.
     * A greeting for the user
     */
    private void greeting() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello it's console chat!!!\n");
        sb.append("I will answer for all your question\n");
        sb.append("Ask me...");
        System.out.println(sb.toString());
    }
}