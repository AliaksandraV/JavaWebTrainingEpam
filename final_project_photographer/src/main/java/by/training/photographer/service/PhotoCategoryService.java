package by.training.photographer.service;

import by.training.photographer.entity.PhotoCategoryEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public interface PhotoCategoryService extends Service<Integer, PhotoCategoryEntity> {

    @Override
    void create(PhotoCategoryEntity entity) throws PersistenceException;

    @Override
    void update(PhotoCategoryEntity entity) throws PersistenceException;

    @Override
    void delete(Integer id) throws PersistenceException;

    @Override
    PhotoCategoryEntity findById(Integer id) throws PersistenceException;

    @Override
    List<PhotoCategoryEntity> findAll() throws PersistenceException;
}
