package ru.job4j.layoutPresentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.layoutPersistent.Person;
import ru.job4j.layoutPersistent.PersonManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CopyOnWriteArrayList;
import com.google.gson.Gson;

public class JsonController extends HttpServlet {

    /**.
     * Logger for this class
     */
    private final Logger logg = LoggerFactory.getLogger(JsonController.class);

    /**.
     * Is storage for persons
     */
    private final CopyOnWriteArrayList<Person> storage = PersonManager.getInstance().getStorage();

    /**.
     * It's getter for this servlet
     * @param req is requaest
     * @param resp is response
     * @throws ServletException may be exception
     * @throws IOException may be exceprions
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String sendPerson = mapper.writeValueAsString(storage);
        PrintWriter writer = resp.getWriter();
        writer.write(sendPerson);
    }

    /**.
     * It's method post for this servlet
     * @param req is request
     * @param resp is response
     * @throws IOException is may be exceptions
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader bf = req.getReader();
        String sb = bf.readLine();
        System.out.println(sb);
        Person person = new Gson().fromJson(sb, Person.class);
        storage.add(person);
    }
}
