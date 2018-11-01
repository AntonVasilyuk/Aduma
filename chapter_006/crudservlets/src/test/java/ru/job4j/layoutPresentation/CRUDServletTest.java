package ru.job4j.layoutPresentation;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.layoutPersistent.DBStore;
import ru.job4j.layoutPersistent.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class CRUDServletTest {

    @Test
    public void createUser() throws ServletException, IOException {
        UserCreateServlet userCreate = new UserCreateServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("name")).thenReturn("test");
        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("password")).thenReturn("test");
        when(request.getParameter("email")).thenReturn("test@test.te");
        when(request.getParameter("role")).thenReturn("user");

        userCreate.doPost(request, response);
        DBStore db = DBStore.getInstance();
        User user = db.findById(db.getId());

        Assert.assertEquals(user.getLogin(), "test");

        verify(request, atLeast(1)).getParameter("name");
        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("password");
        verify(request, atLeast(1)).getParameter("email");
        verify(request, atLeast(1)).getParameter("role");
    }
}