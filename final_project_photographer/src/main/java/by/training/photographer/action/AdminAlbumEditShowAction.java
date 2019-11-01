package by.training.photographer.action;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.PhotoCategoryEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.AlbumService;
import by.training.photographer.service.PhotoCategoryService;
import by.training.photographer.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminAlbumEditShowAction extends Action {

    public AdminAlbumEditShowAction(final ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException, PersistenceException {
        AlbumService albumService = getServiceFactory().createAlbumService();
        PhotoCategoryService categoryService = getServiceFactory().createPhotoCategoryService();

        String[] parts = request.getServletPath().split("/");
        int id = Integer.parseInt(parts[4]);

        AlbumEntity album = albumService.findById(id);
        List<PhotoCategoryEntity> categories = categoryService.findAll();

        request.setAttribute("album", album);
        request.setAttribute("categories", categories);
        forwardToSuccessPage(request, response);
    }

    @Override
    public String getSuccessResponsePageName() {
        return "admin/albumEdit";
    }
}
