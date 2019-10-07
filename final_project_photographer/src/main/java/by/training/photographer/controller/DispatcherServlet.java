package by.training.photographer.controller;

import by.training.photographer.action.Action;
import by.training.photographer.action.AlbumsShowAction;
import by.training.photographer.action.HomePageShowAction;
import by.training.photographer.action.PortfolioShowAction;
import by.training.photographer.exception.PersistenceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    private Action action;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String contextPath = request.getServletPath();
        System.out.println("contextPath:" + contextPath);
        String uri = request.getRequestURI();
        System.out.println("uri:" + uri);

        System.out.println(request.getParameter("id"));
        try {
            switch (contextPath) {
                case "/portfolio":
                    action = new PortfolioShowAction();
                    action.execute(request, response);
                    break;
                case "/home":
                    action = new HomePageShowAction();
                    action.execute(request, response);
                    break;
                case "/album":
                    action = new AlbumsShowAction();
                    action.execute(request, response);
                    break;
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    // todo порядок действий
    // 1. из запроса получаем подстроку с командой (что надо сделать) - на ее основе выполняем действие
    // 2. выносим логику выполнения действия в команды, здесь только определяем нужную команду и вызываем ее (можно для начала свитч-кейсами)
    // 3. делаем map урл_команды - объект_команды (ActionFromUriFilter, только вместо классов будут объекты)
    // 4. заменяем вызов сервиса в команде на сервис фактори (напишем перед этим сервис фактори)

}
