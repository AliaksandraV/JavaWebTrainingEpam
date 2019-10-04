package by.training.photographer.service;

import by.training.photographer.entity.AlbumEntity;

import java.util.List;

public interface AlbumService extends Service<Integer, AlbumEntity> {

    @Override
    void create(AlbumEntity entity);

    @Override
    void update(AlbumEntity entity);

    @Override
    void delete(Integer id);

    @Override
    AlbumEntity findById(Integer id);

    @Override
    List<AlbumEntity> findAll();

    List<AlbumEntity> findByCategory(Integer id);
}
