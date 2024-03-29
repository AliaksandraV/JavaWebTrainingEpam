package by.training.photographer.action;

import by.training.photographer.entity.PaginationResult;
import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.PhotoService;
import by.training.photographer.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PhotoShowAction extends Action {

    public PhotoShowAction(ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException, PersistenceException {
        PhotoService service = getServiceFactory().createPhotoService();

        int currentPage = Integer.valueOf(request.getParameter("page"));

        String[] parts = request.getServletPath().split("/");
        int id = Integer.parseInt(parts[2]);

        PaginationResult<PhotoEntity> pagination = service.findByAlbumWithPagination(id, currentPage, 8);
        List<PhotoEntity> photos = pagination.getList();

        request.setAttribute("photos", photos);
        request.setAttribute("pagination", pagination);
        forwardToSuccessPage(request, response);
    }

    @Override
    public String getSuccessResponsePageName() {
        return "photos";
    }
}
