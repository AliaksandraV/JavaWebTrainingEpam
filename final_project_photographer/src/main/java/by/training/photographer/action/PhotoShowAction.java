package by.training.photographer.action;

import by.training.photographer.service.PhotoService;
import by.training.photographer.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PhotoShowAction extends Action {
    public PhotoShowAction(ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        PhotoService service = getServiceFactory().createPhotoService();

        request.getRequestDispatcher("/WEB-INF/jsp/photos.jsp").forward(request, response);
    }
}
