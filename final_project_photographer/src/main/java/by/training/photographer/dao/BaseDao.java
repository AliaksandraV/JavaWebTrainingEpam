package by.training.photographer.dao;

import by.training.photographer.entity.Entity;

import java.util.List;

public interface BaseDao<K, T extends Entity> {

    void create(T entity);

    void update(T entity);

    void delete(K id);

    T findById(K id);

    List<T> findAll();

}
