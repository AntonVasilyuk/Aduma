package ru.job4j.oracle;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class server for oracle.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 27.03.2019
 */
public class Server {

    /**.
     * Logging
     */
    private static final Logger LOG = Logger.getLogger(Server.class.getName());

    /**.
     * Port for connect to client
     */
    private static final int PORT = 5000;

    /**.
     * Link to socket
     */
    private Socket socket;

    /**.
     * Constructor
     * @param socket to connection
     */
    public Server(Socket socket) {
        this.socket = socket;
    }

    /**.
     * Method for start working servers
     */
    public void start() {
        String ask;
        boolean noExit = true;
        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            do {
                ask = in.readLine();
                if ("hello".equals(ask.toLowerCase())) {
                    out.println("Hello, dear friend, I'm a oracle.");
                    out.println("");
                } else if ("exit".equals(ask.toLowerCase())) {
                    noExit = false;
                    out.println();
                } else {
                    out.println("Another phrases...");
                    out.println();
                }
            } while (noExit);
        } catch (IOException ex) {
            LOG.error(ex.getMessage(), ex);
        }
    }

    /**.
     * Main method
     * @param args it's arguments
     */
    public static void main(String[] args) {
        try (
                final Socket socket =  new ServerSocket(PORT).accept()) {
            Server server = new Server(socket);
            server.start();
        } catch (IOException ex) {
            LOG.error(ex.getMessage(), ex);
        }
    }
}
