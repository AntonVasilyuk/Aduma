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
import java.util.List;

public class UsersServlet extends HttpServlet {

    /**.
     * Is link for instance of the ValidateService class
     */
    private final ValidateService logic = ValidateService.getInstance();

    /**.
     * Is storage for keeping all users
     */
    private final List<User> storage = logic.getListStorage();

    /**.
     * Logger for this class
     */
    private final Logger logger = LoggerFactory.getLogger(UsersServlet.class);

    /**.
     * Method for getting info about client
     * @param req is question
     * @param resp is answer
     * @throws ServletException my be exception
     * @throws IOException it's too
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
        /*StringBuilder sb = new StringBuilder("<form action='" + req.getContextPath() + "/edit' method='post'><table>");
        for (User user : storage) {
            sb.append("<tr>");
            sb.append("<td>" + user.getId() + "</td>");
            sb.append("<td>" + user.getName() + "</td>");
            sb.append("<td>" + user.getLogin() + "</td>");
            sb.append("<td>" + user.getEmail() + "</td>");
            sb.append("<td>" + "<button type='button' form='action'>edit</button>" + "</td>");
            sb.append("<td>" + "<button type='button' form='action'>delete</button>" + "</td>");
            sb.append("</tr>");
        }
        sb.append("</form");
        sb.append("</form");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title>Title</title>" +
                "</head>" +
                "<body>" +
                "<form action='" + req.getContextPath() + "/users' method='post'>" +
                        "<button type='button' form='action'>edit</button>" +
                sb.toString() +
                "</body>" +
                "</html>");
        printWriter.flush();
        */
    }
}
