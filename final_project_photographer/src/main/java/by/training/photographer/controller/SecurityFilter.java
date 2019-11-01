package by.training.photographer.controller;

import by.training.photographer.action.SessionUser;
import by.training.photographer.entity.Role;
import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.MessageFormat;

public class SecurityFilter implements Filter {
    private static Logger logger = Logger.getLogger(SecurityFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;

            if (needAdminRole(req) && !hasRole(req, Role.ADMIN)) {
                String message = MessageFormat.format("Attempt to access resource {0} without admin role", req.getServletPath());
                logger.warn(message);

                req.getRequestDispatcher("/WEB-INF/jsp/forbidden.jsp").forward(req, res);
                return;
            }

            if (needUserRole(req) && !hasRole(req, Role.USER)) {
                String message = MessageFormat.format("Attempt to access resource {0} without user role", req.getServletPath());
                logger.warn(message);

                req.getRequestDispatcher("/WEB-INF/jsp/forbidden.jsp").forward(req, res);
                return;
            }

            chain.doFilter(req, res);
        } else {
            logger.error("It is impossible to use HTTP filter");
            request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }

    private boolean hasRole(HttpServletRequest req, Role role) {
        HttpSession session = req.getSession(false);

        if (session == null) {
            return false;
        }

        SessionUser user = (SessionUser) session.getAttribute("user");

        if (user == null) {
            return false;
        }

        return user.getRole() == role;
    }

    private boolean needAdminRole(HttpServletRequest req) {
        return req.getServletPath().startsWith("/admin");
    }

    private boolean needUserRole(HttpServletRequest req) {
        return req.getServletPath().startsWith("/profile");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
