package by.training.photographer.action;

import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;

public class LogoutAction extends Action {
    private static Logger logger = Logger.getLogger(LogoutAction.class);

    public LogoutAction(ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, PersistenceException {
        Object user = request.getSession().getAttribute("user");
        if (user != null) {
            String message = MessageFormat.format("User {0} log out", ((UserEntity)user).getEmail());
            logger.info(message);

            request.getSession().invalidate();
        }

        redirectToSuccessPage(response);
    }

    @Override
    public String getSuccessResponsePageName() {
        return "home";
    }
}
