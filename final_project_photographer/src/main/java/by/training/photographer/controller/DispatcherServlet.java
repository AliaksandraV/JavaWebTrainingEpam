package by.training.photographer.controller;

import by.training.photographer.entity.PhotoCategoryEntity;
import by.training.photographer.service.PhotoCategoryService;
import by.training.photographer.service.PhotoCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DispatcherServlet extends HttpServlet {
    private PhotoCategoryService service = new PhotoCategoryServiceImpl();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<PhotoCategoryEntity> categories = service.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("WEB-INF/jsp/portfolio.jsp").forward(request, response);

        // todo use request.getServletPath()
    }


}
