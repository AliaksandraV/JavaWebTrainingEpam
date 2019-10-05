package by.training.photographer.dao;

import by.training.photographer.entity.PhotoEntity;

import java.util.List;

public interface PhotoDao extends BaseDao<Integer, PhotoEntity> {

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
