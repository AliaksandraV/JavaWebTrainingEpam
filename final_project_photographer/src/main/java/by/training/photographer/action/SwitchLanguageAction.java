package by.training.photographer.action;

import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SwitchLanguageAction extends Action {

    public SwitchLanguageAction(ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, PersistenceException {
        String language = request.getParameter("language");
        request.getSession().setAttribute("language", language);
        String currentPageLocation = request.getHeader("referer");
        response.sendRedirect(currentPageLocation);
    }

    @Override
    public String getSuccessResponsePageName() {
        return "home";
    }
}
