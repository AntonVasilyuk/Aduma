package ru.job4j.oracle;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Class cliean for oracle.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 27.03.2019
 */

public class Client {

    /**.
     * It's logger
     */
    private static final Logger LOG = Logger.getLogger(Client.class.getName());

    /**.
     * Port for connet
     */
    private static final int port = 5000;

    /**.
     * Local ip
     */
    private static final String host = "127.0.0.1";

    /**.
     * Link for socket
     */
    private Socket socket;

    /**.
     * Constructor
     * @param socket
     */
    public Client(Socket socket) {
        this.socket = socket;
    }

    /**.
     * Method for start working
     */
    public void start() {
        String ask;
        String answer;
        boolean noExit = true;
        try(
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner console = new Scanner(System.in))
        {
            do {
                ask = console.nextLine();
                out.println(ask);
                answer = in.readLine();
                while (!answer.isEmpty()) {
                    System.out.println(answer);
                    answer = in.readLine();
                }
                if ("exit".equals(ask.toLowerCase())) {
                    noExit = false;
                }
            } while (noExit);
            System.out.println("Server is stoped");
        } catch (IOException ex) {
            LOG.error(ex.getMessage(), ex);
        }
    }

    /**.
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        try(Socket socket = new Socket(InetAddress.getByName(host), port)) {
            Client client = new Client(socket);
            client.start();
        } catch (IOException ex) {
            LOG.error(ex.getMessage(), ex);
        }
    }
}
