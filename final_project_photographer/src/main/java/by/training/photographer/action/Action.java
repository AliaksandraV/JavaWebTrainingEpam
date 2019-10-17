package by.training.photographer.action;

import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Action {

    private final ServiceFactory serviceFactory;

    public Action(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, PersistenceException;

    public ServiceFactory getServiceFactory() {
        return serviceFactory;
    }
}
