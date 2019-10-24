package by.training.photographer.action;

import by.training.photographer.entity.Role;
import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.exception.UserDuplicateException;
import by.training.photographer.service.UserService;
import by.training.photographer.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;

public class RegistrationAction extends Action {
    private static Logger logger = Logger.getLogger(RegistrationAction.class);

    private final Role userRole = Role.USER;

    public RegistrationAction(ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        try {
            UserService service = getServiceFactory().createUserService();

            UserEntity user = new UserEntity(
                request.getParameter("email"),
                request.getParameter("password"),
                request.getParameter("name"),
                request.getParameter("phone"),
                userRole);

            service.create(user);

            request.getSession().setAttribute("user", user);
            try (PrintWriter writer = response.getWriter()) {
                String homePath = request.getContextPath() + "/home";
                writer.println(homePath);
            }

        } catch (UserDuplicateException e) {
            String message = MessageFormat.format("User with email {0} already exists", request.getParameter("email"));
            logger.error(message);

            response.setStatus(404);
        } catch (PersistenceException e) {
            logger.error(e);
            //TODO нормальную обработку исключения
        }
    }

    @Override
    public String getSuccessResponsePageName() {
        return "home";
    }
}
