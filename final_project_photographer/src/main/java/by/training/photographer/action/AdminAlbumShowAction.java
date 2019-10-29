package by.training.photographer.action;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.AlbumService;
import by.training.photographer.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminAlbumShowAction extends Action {

    public AdminAlbumShowAction(final ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException, PersistenceException {
        AlbumService albumService = getServiceFactory().createAlbumService();

        List<AlbumEntity> albums = albumService.findAll();

        request.setAttribute("albums", albums);
        forwardToSuccessPage(request, response);
    }

    @Override
    public String getSuccessResponsePageName() {
        return "admin/albumList";
    }
}
