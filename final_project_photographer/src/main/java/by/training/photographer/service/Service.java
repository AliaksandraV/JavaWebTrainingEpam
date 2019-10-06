package by.training.photographer.service;

import by.training.photographer.entity.Entity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public interface Service <K, T extends Entity>  {

    void create(T entity) throws PersistenceException;

    void update(T entity) throws PersistenceException;

    void delete(K id) throws PersistenceException;

    T findById(K id) throws PersistenceException;

    List<T> findAll() throws PersistenceException;
}
