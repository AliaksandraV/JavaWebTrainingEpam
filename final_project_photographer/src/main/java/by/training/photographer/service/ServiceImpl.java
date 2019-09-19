package by.training.photographer.service;

import by.training.photographer.dao.Dao;
import by.training.photographer.entity.Entity;

import java.util.List;

public abstract class ServiceImpl<K, T extends Entity> implements Service<K, T> {
//    private Dao dao;

    @Override
    public void create(final T entity) {
//        dao.create(entity);
    }

    @Override
    public void update(final T entity) {
//        dao.update(entity);
    }

    @Override
    public void delete(final K id) {
//        dao.delete(id);
    }

    @Override
    public T findById(final K id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
