package by.training.photographer.action;

import by.training.photographer.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationShowAction extends Action {

    public RegistrationShowAction(ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        forwardToSuccessPage(request, response);
    }

    @Override
    public String getSuccessResponsePageName() {
        return "registration";
    }
}
