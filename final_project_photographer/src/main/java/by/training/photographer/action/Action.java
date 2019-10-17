package by.training.photographer.action;

import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Action {

    private final ServiceFactory serviceFactory;
    private static final String PREFIX = "/WEB-INF/jsp/";
    private static final String SUFFIX = ".jsp";

    public Action(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, PersistenceException;

    public abstract String getPageName();

    protected void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forward(request, response, getPageName());
    }

    protected void forward(HttpServletRequest request, HttpServletResponse response, String name) throws ServletException, IOException {
        request.getRequestDispatcher(PREFIX + name + SUFFIX).forward(request, response);
    }

    public ServiceFactory getServiceFactory() {
        return serviceFactory;
    }
}
