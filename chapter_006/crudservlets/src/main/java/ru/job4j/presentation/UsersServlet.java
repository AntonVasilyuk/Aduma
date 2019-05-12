package ru.job4j.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.logic.ValidateService;
import ru.job4j.persistent.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**.
 * Task 9.2.1.
 * Class servlet for working with users
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */
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
    private static final Logger LOG = LoggerFactory.getLogger(UsersServlet.class);

    /**.
     * Method for getting info about client
     * @param req is question
     * @param resp is answer
     * @throws ServletException my be exception
     * @throws IOException it's too
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", logic.getListStorage());
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }
}
