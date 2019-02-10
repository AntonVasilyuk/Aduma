package ru.job4j.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
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
        System.out.println("I am servlet!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        List<Place> hall = service.getPlaces();
        System.out.println(hall);
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
        resp.sendRedirect(String.format("index.html", req.getContextPath()));
    }
}
