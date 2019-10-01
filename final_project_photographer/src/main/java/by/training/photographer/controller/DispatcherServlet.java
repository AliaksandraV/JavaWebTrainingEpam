package by.training.photographer.controller;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.PhotoCategoryEntity;
import by.training.photographer.service.AlbumService;
import by.training.photographer.service.AlbumServiceImpl;
import by.training.photographer.service.PhotoCategoryService;
import by.training.photographer.service.PhotoCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String contextPath = request.getServletPath();
        System.out.println("contextPath:" + contextPath);
        String uri = request.getRequestURI();
        System.out.println("uri:"+ uri);

        if (contextPath.equals("/portfolio")){
            doPortfolio(request, response);
        } else if (contextPath.equals("/contact") ){
            doContact(request, response);
        } else if (contextPath.equals("/home")) {
            doHome(request, response);
        }


        // todo use request.getServletPath()
    }

    private void doPortfolio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PhotoCategoryService service = new PhotoCategoryServiceImpl();
        List<PhotoCategoryEntity> categories = service.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("WEB-INF/jsp/portfolio.jsp").forward(request, response);
    }

    private void doContact (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AlbumService service = new AlbumServiceImpl();
        List<AlbumEntity> albums = service.findAll();
        request.setAttribute("albums", albums);
        request.getRequestDispatcher("WEB-INF/jsp/albums.jsp").forward(request,response);
    }

    private void doHome (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(request,response);
    }


    // todo порядок действий
    // 1. из запроса получаем подстроку с командой (что надо сделать) - на ее основе выполняем действие
    // 2. выносим логику выполнения действия в команды, здесь только определяем нужную команду и вызываем ее (можно для начала свитч-кейсами)
    // 3. делаем map урл_команды - объект_команды (ActionFromUriFilter, только вместо классов будут объекты)
    // 4. заменяем вызов сервиса в команде на сервис фактори (напишем перед этим сервис фактори)

}
