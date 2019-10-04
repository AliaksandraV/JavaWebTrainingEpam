package by.training.photographer.action;

import by.training.photographer.entity.PhotoCategoryEntity;
import by.training.photographer.service.PhotoCategoryService;
import by.training.photographer.service.PhotoCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PortfolioShowAction implements Action {
    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        PhotoCategoryService service = new PhotoCategoryServiceImpl();
        List<PhotoCategoryEntity> categories = service.findAll();
//        categories.get(0)
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("WEB-INF/jsp/portfolio.jsp").forward(request, response);
    }
}
