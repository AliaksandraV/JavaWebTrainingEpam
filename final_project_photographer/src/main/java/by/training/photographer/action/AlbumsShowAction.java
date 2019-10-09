package by.training.photographer.action;

import by.training.photographer.dao.AlbumDaoImpl;
import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.AlbumService;
import by.training.photographer.service.AlbumServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AlbumsShowAction implements Action {
    private static Logger logger = Logger.getLogger(AlbumsShowAction.class);

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, PersistenceException, ServletException {

        AlbumService service = new AlbumServiceImpl(new AlbumDaoImpl(null));
        List<AlbumEntity> albums = service.findByCategory(
            Integer.parseInt(request.getParameter("id")));
//пример использования тэгов
//        AlbumList list = new AlbumList(albums);
//        logger.debug(list);
//        request.setAttribute("album_list", list);
        request.setAttribute("albums", albums);
        request.getRequestDispatcher("WEB-INF/jsp/albums.jsp").forward(request, response);

    }
}
