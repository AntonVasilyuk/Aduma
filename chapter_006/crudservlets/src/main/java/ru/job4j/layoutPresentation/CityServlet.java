package ru.job4j.layoutPresentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.layoutLogic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CityServlet extends HttpServlet {

    /**.
     * It's link to logic layot
     */
    private static final ValidateService service = ValidateService.getInstance();

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
        String country = req.getParameter("country");
        System.out.println(country);
        list = service.getCity(country);
        PrintWriter writer = resp.getWriter();
        writer.print(mapper.writeValueAsString(list));
        System.out.println(list.size());
    }
}
