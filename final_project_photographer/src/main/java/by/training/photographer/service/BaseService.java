package by.training.photographer.service;

import by.training.photographer.dao.connection.Transaction;
import by.training.photographer.entity.Entity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public interface BaseService<K, T extends Entity> {

    Integer create(T entity) throws PersistenceException;

    void update(T entity) throws PersistenceException;

    void delete(K id) throws PersistenceException;

    T findById(K id) throws PersistenceException;

    List<T> findAll() throws PersistenceException;

    Transaction createTransaction();
}
