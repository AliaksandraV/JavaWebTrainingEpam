package by.training.photographer.action;

import by.training.photographer.entity.Role;
import by.training.photographer.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginAction implements Action {

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        System.out.println(request.getContextPath());
        System.out.println(request.getParameter("email"));
        System.out.println(request.getParameter("password"));
        System.out.println("Сюда зашли))");

//        UserService service = new UserServiceImpl();
        String username = request.getParameter("email");
        String password = request.getParameter("password");
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setEmail("somemail1@gmail.com");
        user.setPassword("Aa123+");
        user.setName("Nata");
        user.setPhoneNumber("+375-29-255-04-62");
        user.setRole(Role.USER);

        List<UserEntity> users = new ArrayList<>();
        users.add(user);

        for (UserEntity entity:users) {
            if (entity.getEmail().equals(username)&& entity.getPassword().equals(password)){
                System.out.println("user EXIST");
            } else {
                System.out.println("NO such user");
            }
        }

        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("home");
        }
        else {
            request.setAttribute("error", "Unknown user, please try again");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

//        request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,response);
    }
}
