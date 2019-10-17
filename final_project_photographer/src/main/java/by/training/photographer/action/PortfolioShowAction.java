package by.training.photographer.action;

import by.training.photographer.entity.PhotoCategoryEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.PhotoCategoryService;
import by.training.photographer.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PortfolioShowAction extends Action {
    public PortfolioShowAction(ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException, PersistenceException {
        PhotoCategoryService service = getServiceFactory().createPhotoCategoryService();
        List<PhotoCategoryEntity> categories;
        categories = service.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/jsp/portfolio.jsp").forward(request, response);
    }
}
