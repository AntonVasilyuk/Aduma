package ru.job4j.controller;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class is filter for working servlet HallServlet.
 * @author Anton Vasilyuk (z241287@yandex.ru)
 * @version 0.1$
 * @since 0.1
 * 02.03.2019
 */

public class AuthFilter implements Filter {

    /**.
     * Method for inicialisation
     * @param filterConfig it's config data
     * @throws ServletException occurs when there is an error in the servlet
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //TODO
    }

    /**.
     * Instance param to the request
     * @param request it's request
     * @param response it's response
     * @param chain it's filter
     * @throws IOException occurs when is an error in the working stream
     * @throws ServletException occurs when is an error in the working servlet
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

    /**.
     * Method for destroing
     */
    @Override
    public void destroy() {
        //TODO
    }
}
