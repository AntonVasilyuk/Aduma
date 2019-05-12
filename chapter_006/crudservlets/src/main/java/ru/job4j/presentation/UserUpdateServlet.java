package ru.job4j.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.logic.ValidateService;
import ru.job4j.persistent.ConditionRegistration;
import ru.job4j.persistent.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;

/**.
 * Task 9.2.1.
 * Class servlet for update users
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */
public class UserUpdateServlet extends HttpServlet {

    /**.
     * Is link for instance of the ValidateService class
     */
    private final ValidateService logic = ValidateService.getInstance();

    /**.
     * Logger for this class
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserUpdateServlet.class);

    /**.
     * Method for getting info about client
     * @param req is question
     * @param resp is answer
     * @throws ServletException my be exception
     * @throws IOException it's too
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        req.setAttribute("id", id);
        req.setAttribute("name", name);
        req.setAttribute("login", login);
        req.setAttribute("password", password);
        req.setAttribute("email", email);
        req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
    }

    /**.
     * Method for posting info
     * @param req is question
     * @param resp is answer
     * @throws ServletException my be exception
     * @throws IOException it's too
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String role = req.getParameter("role");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        if (!id.equals("")) {
            logic.update(new User(Integer.parseInt(id), name, login, password, email, role, new ConditionRegistration(
                    new GregorianCalendar().getTimeInMillis(), country, city)));
        } else {
            LOGGER.info("Not correct id for updating.");
        }
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
