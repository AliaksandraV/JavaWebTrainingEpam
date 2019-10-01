package by.training.photographer;

import by.training.photographer.dao.*;
import by.training.photographer.entity.*;
import by.training.photographer.service.*;

import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        checkUserDao();
//        checkAlbumDao();
//        checkAlbumFindAll();

//        AlbumService service = new AlbumServiceImpl();
//        List<AlbumEntity> albums = service.findAll();
//        for (AlbumEntity album : albums) {
//            System.out.println(album);
//        }

//        System.out.println(service.findById(3));

//        LikeService service1 = new LikeServiceImpl();
//        List<LikeEntity> likes = service1.findAll();
//        for (LikeEntity like : likes) {
//            System.out.println(like);
//        }
//
//        System.out.println(service1.findById(4));

//        LocalizedTextService service = new LocalizedTextServiceImpl();
//        List<LocalizedTextEntity> texts = service.findAll();
//        for (LocalizedTextEntity text : texts) {
//            System.out.println(text);
//        }
//
//        System.out.println(service.findById(5));

//        PhotoCategoryService service = new PhotoCategoryServiceImpl();
//        List<PhotoCategoryEntity> categories = service.findAll();
//        for (PhotoCategoryEntity cat : categories) {
//            System.out.println(cat);
//        }
//
//        System.out.println(service.findById(5));

//        PhotoService service = new PhotoServiceImpl();
//        List<PhotoEntity> photos = service.findAll();
//        for (PhotoEntity photo : photos) {
//            System.out.println(photo);
//        }
//
//        System.out.println(service.findById(1));

//        UserService service = new UserServiceImpl();
//        List<UserEntity> users = service.findAll();
//        for (UserEntity user : users) {
//            System.out.println(user);
//        }
//
//        System.out.println(service.findById(1));

        AlbumServiceImpl service = new AlbumServiceImpl();
        List<AlbumEntity> albums = service.findAll();
        for (AlbumEntity album : albums) {
            System.out.println(album);
        }

//        AlbumDao dao = new AlbumDaoImpl();
//        List<AlbumEntity> albums = dao.findAll();
//        for (AlbumEntity album : albums) {
//            System.out.println(album);
//        }

        System.out.println("________");
        System.out.println(service.findById(3));

    }

    private static void checkUserDao() {
        UserEntity user = new UserEntity();
        user.setEmail("someMilo3@mail.ru");
        user.setPassword("Aa123+");
        user.setName("Roma");
        user.setPhoneNumber("+375299992883");
        user.setRole(2);

        UserDaoImpl dao = new UserDaoImpl();

//        dao.create(user);

//        user.setId(6);
//        dao.update(user);
//        dao.delete(6);

//        List<UserEntity> users = dao.findAll();
//        for (UserEntity u: users){
//            System.out.println(u);
//        }

        System.out.println(dao.findById(4));

    }

    private static void checkAlbumDao() {
        AlbumEntity album = new AlbumEntity();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 6);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        album.setDate(calendar);

        PhotoCategoryEntity category = new PhotoCategoryEntity();
        category.setId(1);
        album.setPhotoCategory(category);

        AlbumDaoImpl dao = new AlbumDaoImpl();
//        dao.create(album);
//        album.setId(14);
//        dao.update(album);
//        dao.delete(13);
//        List<AlbumEntity> albums = dao.findAll();
//        for (AlbumEntity a : albums) {
//            System.out.println(a);
//        }

        AlbumEntity album1 = new AlbumEntity();
        album1 = dao.findById(1);
        System.out.println(album1);
    }

    private static void checkCategoryFindAll() {
        PhotoCategoryDao dao = new PhotoCategoryDaoImpl();
        List<PhotoCategoryEntity> categories = dao.findAll();
        for (PhotoCategoryEntity category : categories) {
            LocalizedTextDao textDao = new LocalizedTextDaoImpl();
            int id = category.getLocalizedName().getId();
            LocalizedTextEntity name = textDao.findById(id);
            category.setLocalizedName(name);
            System.out.println(category);
        }
    }

    private static void checkAlbumFindAll() {
        AlbumDao albumDao = new AlbumDaoImpl();
        List<AlbumEntity> albums = albumDao.findAll();
//        for (AlbumEntity album : albums) {
//            LocalizedTextDao textDao = new LocalizedTextDaoImpl();
//            album.setNameEntity(textDao.findById(album.getNameEntity().getId()));
//            if(album.getDescriptionEntity()!=null){
//                LocalizedTextEntity text = textDao.findById(album.getDescriptionEntity().getId());
//                album.setDescriptionEntity(text);
//            }
//            PhotoCategoryDao categoryDao = new PhotoCategoryDaoImpl();
//            album.setPhotoCategory(categoryDao.findById(album.getPhotoCategory().getId()));
//            System.out.println(album);
//        }
    }
}

