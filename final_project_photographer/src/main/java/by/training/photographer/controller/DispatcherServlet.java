package by.training.photographer.controller;

import by.training.photographer.action.Action;
import by.training.photographer.dao.DaoFactoryImpl;
import by.training.photographer.dao.connection.DataSource;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.factory.ServiceFactoryImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(getClass());

    private final ActionFactory actionFactory = new ActionFactoryImpl(new ServiceFactoryImpl(new DaoFactoryImpl()));

    @Override
    public void init() {
        try {
            DataSource.init();
        } catch (PersistenceException e) {
            logger.error("It is impossible to initialize application", e);
            destroy();
        }
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("DispatcherServlet GET");
        process(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
       logger.debug("DispatcherServlet POST");
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String contextPath = request.getServletPath();
        String uri = request.getRequestURI();

        try {
            Action action = actionFactory.create(contextPath);
            action.execute(request, response);
        } catch (Exception e) {
            logger.error("It is impossible to create action handler object", e);
            request.setAttribute("error", String.format("Запрошенный адрес %s не может быть обработан сервером", uri));
            request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
