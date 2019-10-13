package by.training.photographer.service;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public interface AlbumService extends BaseService<Integer, AlbumEntity> {

    @Override
    Integer create(AlbumEntity entity) throws PersistenceException;

    @Override
    void update(AlbumEntity entity) throws PersistenceException;

    @Override
    void delete(Integer id) throws PersistenceException;

    @Override
    AlbumEntity findById(Integer id) throws PersistenceException;

    @Override
    List<AlbumEntity> findAll() throws PersistenceException;

    List<AlbumEntity> findByCategory(Integer id) throws PersistenceException;
}
