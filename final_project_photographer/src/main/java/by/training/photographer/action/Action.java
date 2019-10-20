package by.training.photographer.action;

import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Action {

    private static final String PREFIX = "/WEB-INF/jsp/";
    private static final String SUFFIX = ".jsp";

    private final ServiceFactory serviceFactory;

    public Action(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, PersistenceException;

    public abstract String getSuccessResponsePageName();

    protected void redirectToSuccessPage(HttpServletResponse response) throws ServletException, IOException {
        redirectToSuccessPage(response, getSuccessResponsePageName());
    }

    protected void redirectToSuccessPage(HttpServletResponse response, String name) throws ServletException, IOException {
        response.sendRedirect(name);
    }

    protected void forwardToSuccessPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forwardToPage(request, response, getSuccessResponsePageName());
    }

    protected void forwardToPage(HttpServletRequest request, HttpServletResponse response, String name) throws ServletException, IOException {
        request.getRequestDispatcher(getPath(name)).forward(request, response);
    }

    private String getPath(String name) {
        return PREFIX + name + SUFFIX;
    }

    public ServiceFactory getServiceFactory() {
        return serviceFactory;
    }
}
