package by.training.photographer.dao;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.PhotoCategoryEntity;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import static by.training.photographer.dao.CreateConection.initConnection;
import static org.testng.Assert.*;

public class AlbumDaoImplTest {
    AlbumEntity album = new AlbumEntity();
//     AlbumDaoImpl dao = new AlbumDaoImpl();

    @BeforeTest
    private void createAlbum() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 6);
        album.setDate(calendar);
        PhotoCategoryEntity category = new PhotoCategoryEntity();
        category.setId(1);
        album.setPhotoCategory(category);

//        dao.create(album);
//        album.setId(14);
//        dao.update(album);
//        dao.delete(13);
//        List<AlbumEntity> albums = dao.findAll();
//        for (AlbumEntity a : albums) {
//            System.out.println(a);
//        }

        AlbumEntity album1 = new AlbumEntity();
//        album1 = dao.findById(1);
        System.out.println(album1);
    }

    @Test
    public void testCreate() {

    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testFindById() {
    }

    @Test
    public void testFindAll() {
    }
}