package ru.job4j.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.apache.log4j.Logger;
import ru.job4j.persistence.Place;
import ru.job4j.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Class servlet, to exchange data with database.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 02.03.2019
 */

public class HallServlet extends HttpServlet {

    /**.
     * Logger
     */
    private static final Logger LOGG = Logger.getLogger(HallServlet.class.getName());

    /**.
     * Example for class Service
     */
    private final Service service = Service.getInstance();

    /**.
     * Realisetion method get
     * @param req is request
     * @param resp is response
     * @throws ServletException occurs when there is an error in the servlets
     * @throws IOException occurs when there is an error in the exchange data to streams
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
