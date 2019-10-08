package by.training.photographer.service;

import by.training.photographer.entity.LikeEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public interface LikeService extends Service<Integer, LikeEntity> {

    @Override
    void create(LikeEntity entity) throws PersistenceException;

    @Override
    void update(LikeEntity entity) throws PersistenceException;

    @Override
    void delete(Integer id) throws PersistenceException;

    @Override
    LikeEntity findById(Integer id) throws PersistenceException;

    @Override
    List<LikeEntity> findAll() throws PersistenceException;
}
