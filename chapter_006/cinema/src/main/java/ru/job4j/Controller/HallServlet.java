package ru.job4j.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.Persistence.Place;
import ru.job4j.Service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class HallServlet extends HttpServlet {

    private static final Logger logg = LoggerFactory.getLogger(HallServlet.class);
    /**.
     * Example for class Service
     */
    private final Service service = Service.getInstance();

    /**.
     * Realisetion method get
     * @param req is request
     * @param resp is response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Place> hall = service.getPlaces();
        resp.getWriter().write(mapper.writeValueAsString(service.getPlaces()));
    }

    /**.
     * Realisation method post
     * @param req is request
     * @param resp is response
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader bf = null;
        bf = req.getReader();
        String sb = null;
        sb = bf.readLine();
        Place place = new Gson().fromJson(sb, Place.class);
        service.add(place);
        resp.sendRedirect(String.format("%s/index.html", req.getContextPath()));
    }
}
