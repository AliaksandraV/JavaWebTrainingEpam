package by.training.photographer.service;

import by.training.photographer.entity.PhotoEntity;

import java.util.List;

public interface PhotoService extends Service<Integer, PhotoEntity> {

    @Override
    void create(PhotoEntity entity);

    @Override
    void update(PhotoEntity entity);

    @Override
    void delete(Integer id);

    @Override
    PhotoEntity findById(Integer id);

    @Override
    List<PhotoEntity> findAll();
}
