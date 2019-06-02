package ru.job4j.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**.
 * Task 9.2.1.
 * Class servlet for working with country
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */
public class CountryServlet extends HttpServlet {

    /**.
     * It's link to logic layout
     */
    private static final ValidateService SERVICE = ValidateService.getInstance();

    /**.
     * It's getter for this servlet
     * @param req is requaest
     * @param resp is response
     * @throws ServletException may be exception
     * @throws IOException may be exceprions
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list = null;
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        list = SERVICE.getCountries();
        PrintWriter writer = resp.getWriter();
        writer.print(mapper.writeValueAsString(list));
    }
}
