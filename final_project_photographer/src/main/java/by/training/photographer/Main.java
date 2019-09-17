package by.training.photographer;

import by.training.photographer.dao.AlbumDaoImpl;
import by.training.photographer.dao.UserDaoImpl;
import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.PhotoCategoryEntity;
import by.training.photographer.entity.UserEntity;

import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        checkUserDao();
        checkAlbumDao();
    }

    private static void checkUserDao() {
        UserEntity user = new UserEntity();
        user.setEmail("someMilo3@mail.ru");
        user.setPassword("Aa123+");
        user.setName("Roma");
        user.setPhone_number("+375299992883");
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
}
