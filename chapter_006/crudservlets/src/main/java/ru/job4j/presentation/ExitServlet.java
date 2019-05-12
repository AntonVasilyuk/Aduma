package ru.job4j.presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**.
 * Task 9.2.1.
 * Class servlet for existing
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */

public class ExitServlet extends HttpServlet {

    /**.
     * It's getter for this servlet
     * @param req is requaest
     * @param resp is response
     * @throws ServletException may be exception
     * @throws IOException may be exceprions
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(String.format("%s/signin", req.getContextPath()));
    }
}
