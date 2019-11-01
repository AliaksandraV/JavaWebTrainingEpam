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

public class EditProfileAction extends Action {
    private static Logger logger = Logger.getLogger(EditProfileAction.class);

    public EditProfileAction(final ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException, PersistenceException {
        UserService service = getServiceFactory().createUserService();

        // 1. check old password and session email
        SessionUser user = (SessionUser) request.getSession().getAttribute("user");
        String email = user.getEmail();
        String oldPassword = request.getParameter("old-password");
        UserEntity existingUser = service.findByEmailAndPassword(email, oldPassword);

        if (existingUser == null) {
            String message = MessageFormat.format("Invalid password for email {0}", request.getParameter("email"));
            logger.error(message);

            response.setStatus(400);
            return;
        }

        try {
            // 2. update user
            UserEntity userForUpdating = new UserEntity(
                user.getId(),
                request.getParameter("email"),
                null,
                null,
                request.getParameter("name"),
                request.getParameter("phone"),
                Role.USER);

            UserEntity updatedEntity = service.update(userForUpdating, request.getParameter("new-password"));
            SessionUser newSessionUser = new SessionUser(updatedEntity);
            request.getSession().setAttribute("user", newSessionUser);

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
