package ru.job4j.LayoutPresentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.LayoutLogic.ValidateService;
import ru.job4j.LayoutPersistent.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**.
 * Task 9.2.1.
 * Servlet for this programm
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */

public class UserServlet extends HttpServlet{

    /**.
     * Is link for instance of the ValidateService class
     */
    private final ValidateService logic = ValidateService.getInstance();

    /**.
     * Logger for this class
     */
    private final Logger logger = LoggerFactory.getLogger(UserServlet.class);

    /**.
     * Method for getting info about client
     * @param req is question
     * @param resp is answer
     * @throws ServletException my be exception
     * @throws IOException it's too
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/httl");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        List<User> listUsers = logic.getListStorage();
        for (User user : listUsers) {
            printWriter.append(user.toString());
        }
        printWriter.flush();

    }

    /**.
     * Method for posting info
     * @param req is question
     * @param resp is answer
     * @throws ServletException my be exception
     * @throws IOException it's too
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String action = req.getParameter("action");
        if (action.equals("add")) {
            String name = req.getParameter("name");
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            logic.add(name, login, email);
            doGet(req, resp);
        } else if (action.equals("update")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            logic.update(id, name, login, email);
            doGet(req, resp);
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            logic.delete(id);
            doGet(req, resp);
        } else if (action.equals("hello")) {
            resp.setContentType("text/httl");
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.append("Hello");
            printWriter.flush();
        }
    }
}
