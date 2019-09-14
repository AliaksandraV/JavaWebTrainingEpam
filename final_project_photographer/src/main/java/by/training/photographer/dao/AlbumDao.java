package by.training.photographer.dao;

import by.training.photographer.entity.AlbumEntity;

import java.util.List;

public interface AlbumDao {

    void create(AlbumEntity album);

    void update(AlbumEntity album);

    void delete(long id);

    void delete(AlbumEntity entity);

    AlbumEntity findById(long id);

    List<AlbumEntity> findAll();
}
