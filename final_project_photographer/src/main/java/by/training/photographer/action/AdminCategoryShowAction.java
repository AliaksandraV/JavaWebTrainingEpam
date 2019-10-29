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

public class AdminCategoryShowAction extends Action {

    public AdminCategoryShowAction(ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, PersistenceException {
        PhotoCategoryService categoryService = getServiceFactory().createPhotoCategoryService();

        List<PhotoCategoryEntity> categories = categoryService.findAll();

        request.setAttribute("categories", categories);
        forwardToSuccessPage(request, response);
    }

    @Override
    public String getSuccessResponsePageName() {
        return "admin/categoryList";
    }
}
