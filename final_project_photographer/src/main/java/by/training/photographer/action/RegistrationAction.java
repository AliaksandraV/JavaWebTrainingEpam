package by.training.photographer.action;

import by.training.photographer.dao.DaoFactoryImpl;
import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.UserService;
import by.training.photographer.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationAction implements Action {
    private final int userRole = 2;

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, PersistenceException {
        UserService service = new UserServiceImpl(new DaoFactoryImpl());

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
}
