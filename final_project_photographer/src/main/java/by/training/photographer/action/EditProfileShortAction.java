package by.training.photographer.action;

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

public class EditProfileShortAction extends Action {
    private static Logger logger = Logger.getLogger(EditProfileShortAction.class);

    public EditProfileShortAction(final ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException, PersistenceException {
        UserService service = getServiceFactory().createUserService();

        SessionUser sessionUser = ((SessionUser)request.getSession().getAttribute("user"));
        String email = request.getParameter("email");
        try {
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            service.update(sessionUser.getId(), email, name, phone);
            sessionUser.setEmail(email);
            sessionUser.setName(name);
            sessionUser.setPhoneNumber(phone);

            try (PrintWriter writer = response.getWriter()) {
                String homePath = request.getContextPath() + "/home";
                writer.println(homePath);
            }

        } catch (UserDuplicateException e) {
            String message = MessageFormat.format("User with email {0} already exists", email);
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
