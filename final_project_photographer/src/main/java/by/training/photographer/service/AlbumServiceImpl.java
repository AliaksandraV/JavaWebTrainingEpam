package by.training.photographer.service;

import by.training.photographer.dao.*;
import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.LocalizedTextEntity;

import java.util.List;

public class AlbumServiceImpl implements AlbumService {

    private AlbumDao dao = new AlbumDaoImpl();

    @Override
    public void create(final AlbumEntity entity) {
        dao.create(entity);
    }

    @Override
    public void update(final AlbumEntity entity) {
        dao.update(entity);
    }

    @Override
    public void delete(final Integer id) {
        dao.delete(id);
    }

    @Override
    public AlbumEntity findById(final Integer id) {
//        AlbumEntity album = dao.findById(id);
//        buildAlbum(album);
//        return album;
        return dao.findById(id);
    }

    @Override
    public List<AlbumEntity> findAll() {
//        List<AlbumEntity> albums = dao.findAll();
//        for (AlbumEntity album : albums) {
//           buildAlbum(album);
//        }
//        return albums;
        return dao.findAll();
    }

    public List<AlbumEntity> query(final Integer specification){
        List<AlbumEntity> albums = dao.query(specification);
//        for (AlbumEntity album : albums) {
//            buildAlbum(album);
//        }
        return albums;

    }

    private AlbumEntity buildAlbum (final AlbumEntity album){
//        LocalizedTextDao textDao = new LocalizedTextDaoImpl();
//        if (album.getNameEntity()!=null) {
//            album.setNameEntity(textDao.findById(album.getNameEntity().getId()));
//        }
//        if(album.getDescriptionEntity()!=null){
//            LocalizedTextEntity text = textDao.findById(album.getDescriptionEntity().getId());
//            album.setDescriptionEntity(text);
//        }
//        PhotoCategoryDao categoryDao = new PhotoCategoryDaoImpl();
//        album.setPhotoCategory(categoryDao.findById(album.getPhotoCategory().getId()));
        return album;
    }
}
