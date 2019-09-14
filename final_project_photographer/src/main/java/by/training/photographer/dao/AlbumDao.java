package by.training.photographer.dao;

import by.training.photographer.entity.AlbumEntity;

import java.util.List;

public interface AlbumDao extends Dao <Integer, AlbumEntity> {

    void create(AlbumEntity album);

    void update(AlbumEntity album);

    void delete(Integer id);

    void delete(AlbumEntity entity);

    AlbumEntity findById(Integer id);

    List<AlbumEntity> findAll();
}
