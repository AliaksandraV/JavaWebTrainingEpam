package by.training.photographer.action;

import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.UserService;
import by.training.photographer.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;

public class LoginAction extends Action {
    private static Logger logger = Logger.getLogger(LoginAction.class);

    public LoginAction(ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException, PersistenceException {
        UserService userService = getServiceFactory().createUserService();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserEntity userEntity = userService.findByEmailAndPassword(email, password);

        if (userEntity != null) {
            User sessionUser = new User(userEntity.getId(), userEntity.getEmail(), userEntity.getName(), userEntity.getPhoneNumber(), userEntity.getRole());

            request.getSession().setAttribute("user", sessionUser);
        } else {
            String message = MessageFormat.format("Attempt to sign in by email {0} failed", email);
            logger.warn(message);

            response.setStatus(404);
        }
    }

    @Override
    public String getSuccessResponsePageName() {
        return "home";
    }
}
