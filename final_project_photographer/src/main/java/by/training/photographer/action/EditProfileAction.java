package by.training.photographer.action;

import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.UserService;
import by.training.photographer.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProfileAction extends Action {
    private static Logger logger = Logger.getLogger(EditProfileAction.class);


    public EditProfileAction(final ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException, PersistenceException {
//        try {
            UserService service = getServiceFactory().createUserService();

            int id = ((User)request.getSession().getAttribute("user")).getId();
//TODO implement
//            UserEntity user = new UserEntity(
//                id,
//                request.getParameter("email"),
//                request.getParameter("password"),
//                request.getParameter("name"),
//                request.getParameter("phone"),
//                request.getParameter("userRole"));

//            service.create(user);

//            try (PrintWriter writer = response.getWriter()) {
//                String homePath = request.getContextPath() + "/home";
//                writer.println(homePath);
//            }
//
//        } catch (UserDuplicateException e) {
//            String message = MessageFormat.format("User with email {0} already exists", request.getParameter("email"));
//            logger.error(message);
//
//            response.setStatus(404);
//        } catch (PersistenceException e) {
//            logger.error(e);
//            //TODO нормальную обработку исключения
//        }
    }

    @Override
    public String getSuccessResponsePageName() {
        return "home";
    }
}
