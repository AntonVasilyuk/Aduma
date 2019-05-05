package ru.job4j.chat;

/**
 * Class for start console chat.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 11.03.2019
 */
public class ChatApp {

    /**.
     * Main method
     * @param args it's param for start apps
     */
    public static void main(String[] args) {
        new ChatLogic().startChat();
    }
}
