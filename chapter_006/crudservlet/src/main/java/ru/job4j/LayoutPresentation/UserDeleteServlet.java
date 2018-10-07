package ru.job4j.LayoutPresentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.LayoutLogic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteServlet extends HttpServlet {

    /**.
     * Is link for instance of the ValidateService class
     */
    private final ValidateService logic = ValidateService.getInstance();

    /**.
     * Logger for this class
     */
    private final Logger logger = LoggerFactory.getLogger(UserDeleteServlet.class);

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
        resp.sendRedirect(String.format("%s/delete.jsp", req.getContextPath()));
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
        int id = Integer.parseInt(req.getParameter("id"));
        logic.delete(id);
        doGet(req, resp);
    }

}