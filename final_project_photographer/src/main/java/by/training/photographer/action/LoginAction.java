package by.training.photographer.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAction implements Action {

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Сюда зашли))");
        request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,response);
    }
}
