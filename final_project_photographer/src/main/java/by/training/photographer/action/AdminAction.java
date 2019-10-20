package by.training.photographer.action;

import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminAction extends Action {

    public AdminAction(ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, PersistenceException {
        // todo implement
        forwardToSuccessPage(request, response);
    }

    @Override
    public String getSuccessResponsePageName() {
        return "admin";
    }
}
