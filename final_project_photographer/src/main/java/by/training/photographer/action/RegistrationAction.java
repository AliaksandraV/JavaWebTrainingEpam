package by.training.photographer.action;

import by.training.photographer.entity.Role;
import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.UserService;
import by.training.photographer.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationAction extends Action {
    private final Role userRole = Role.USER;

    public RegistrationAction(ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, PersistenceException {
        UserService service = getServiceFactory().createUserService();

        UserEntity user = new UserEntity(
            request.getParameter("email"),
            request.getParameter("password"),
            request.getParameter("name"),
            request.getParameter("phone"),
            userRole);

        service.create(user);

        request.getSession().setAttribute("user", user);
        response.sendRedirect("home");
    }

    @Override
    public String getSuccessResponsePageName() {
        throw new IllegalStateException(); // todo
    }
}
