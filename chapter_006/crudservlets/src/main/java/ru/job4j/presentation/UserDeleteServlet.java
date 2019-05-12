package ru.job4j.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**.
 * Task 9.2.1.
 * Class servlet for deleting
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */

public class UserDeleteServlet extends HttpServlet {

    /**.
     * Is link for instance of the ValidateService class
     */
    private final ValidateService logic = ValidateService.getInstance();

    /**.
     * Logger for this class
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserDeleteServlet.class);

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
        int id = Integer.parseInt(req.getParameter("id"));
        logic.delete(id);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }

}