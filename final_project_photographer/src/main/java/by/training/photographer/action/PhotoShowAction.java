package by.training.photographer.action;

import by.training.photographer.dao.DaoFactoryImpl;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.PhotoService;
import by.training.photographer.service.PhotoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PhotoShowAction implements Action {
    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException, PersistenceException {
        PhotoService service = new PhotoServiceImpl(new DaoFactoryImpl());

        request.getRequestDispatcher("/WEB-INF/jsp/photos.jsp").forward(request, response);
    }
}
