package by.training.photographer.service;

import by.training.photographer.entity.LocalizedTextEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public interface LocalizedTextService extends BaseService<Integer, LocalizedTextEntity> {

    @Override
    Integer create(LocalizedTextEntity entity) throws PersistenceException;

    @Override
    void update(LocalizedTextEntity entity) throws PersistenceException;

    @Override
    void delete(Integer id) throws PersistenceException;

    @Override
    LocalizedTextEntity findById(Integer id) throws PersistenceException;

    @Override
    List<LocalizedTextEntity> findAll() throws PersistenceException;
}
