package by.training.photographer.service;

import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public interface PhotoService extends Service<Integer, PhotoEntity> {

    @Override
    void create(PhotoEntity entity) throws PersistenceException;

    @Override
    void update(PhotoEntity entity) throws PersistenceException;

    @Override
    void delete(Integer id) throws PersistenceException;

    @Override
    PhotoEntity findById(Integer id) throws PersistenceException;

    @Override
    List<PhotoEntity> findAll() throws PersistenceException;
}
