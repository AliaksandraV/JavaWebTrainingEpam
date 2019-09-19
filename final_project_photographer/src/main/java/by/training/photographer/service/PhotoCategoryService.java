package by.training.photographer.service;

import by.training.photographer.entity.PhotoCategoryEntity;

import java.util.List;

public interface PhotoCategoryService extends Service<Integer, PhotoCategoryEntity> {

    @Override
    void create(PhotoCategoryEntity entity);

    @Override
    void update(PhotoCategoryEntity entity);

    @Override
    void delete(Integer id);

    @Override
    PhotoCategoryEntity findById(Integer id);

    @Override
    List<PhotoCategoryEntity> findAll();
}
