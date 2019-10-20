package by.training.photographer.action;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.AlbumService;
import by.training.photographer.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AlbumsShowAction extends Action {
    private static Logger logger = Logger.getLogger(AlbumsShowAction.class);

    public AlbumsShowAction(ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, PersistenceException, ServletException {
        AlbumService service = getServiceFactory().createAlbumService();

        String[] parts = request.getServletPath().split("/");
        int id = Integer.parseInt(parts[2]);

        List<AlbumEntity> albums = service.findByCategory(id);
//пример использования тэгов
//        AlbumList list = new AlbumList(albums);
//        logger.debug(list);
//        request.setAttribute("album_list", list);
        request.setAttribute("albums", albums);
        forwardToSuccessPage(request, response);
    }

    @Override
    public String getSuccessResponsePageName() {
        return "albums";
    }
}
