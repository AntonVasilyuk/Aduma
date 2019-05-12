package ru.job4j.presentation;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**.
 * Task 9.2.1.
 * Class servlet for filter
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 */
public class AuthFilter implements Filter {

    /**.
     * Method init
     * @param filterConfig is filter config
     * @throws ServletException may be exception
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**.
     * Is do filter
     * @param req is request
     * @param resp is response
     * @param chain is chain
     * @throws IOException may be exception
     * @throws ServletException may be exception
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getRequestURI().contains("/signin")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session = request.getSession();
            if (session.getAttribute("login") == null) {
                ((HttpServletResponse) resp).sendRedirect(String.format("%s/signin", request.getContextPath()));
                return;
            }
            chain.doFilter(req, resp);
        }
    }

    /**.
     * Method for destroy
     */
    @Override
    public void destroy() {
    }
}
