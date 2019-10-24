package by.training.photographer.action;

import by.training.photographer.entity.PaginationResult;
import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.PhotoService;
import by.training.photographer.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PhotoShowAction extends Action {
    private static Logger logger = Logger.getLogger(PhotoShowAction.class);

    public PhotoShowAction(ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException, PersistenceException {
        PhotoService service = getServiceFactory().createPhotoService();

        int currentPage = Integer.valueOf(request.getParameter("page"));
        System.out.println("Cur page " +currentPage);

        String[] parts = request.getServletPath().split("/");
        int id = Integer.parseInt(parts[2]);


        PaginationResult<PhotoEntity> pagination = service.findByAlbum(id, currentPage, 8);
        List<PhotoEntity> photos = pagination.getList();

//        System.out.println("IN servlet " + pagination);
        System.out.println("Total pages " + pagination.getTotalPages());
        System.out.println("Vsego zapisei " + pagination.getTotalRecords());
        System.out.println("Current pages " + pagination.getCurrentPage());
        System.out.println("Current pages " + pagination.getStepAmount());

        request.setAttribute("photos", photos);
        request.setAttribute("pagination", pagination);
        forwardToSuccessPage(request, response);
    }

    @Override
    public String getSuccessResponsePageName() {
        return "photos";
    }
}
