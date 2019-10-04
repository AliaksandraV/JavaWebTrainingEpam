package by.training.photographer.service;

import by.training.photographer.dao.*;
import by.training.photographer.entity.AlbumEntity;

import java.util.List;

public class AlbumServiceImpl implements AlbumService {

    private final AlbumDao dao;

    public AlbumServiceImpl(final AlbumDao dao) {
        this.dao = dao;
    }

    @Override
    public void create(final AlbumEntity entity) {
        dao.create(entity);
    }

    @Override
    public void update(final AlbumEntity entity) {
        dao.update(entity);
    }

    @Override
    public void delete(final Integer id) {
        dao.delete(id);
    }

    @Override
    public AlbumEntity findById(final Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<AlbumEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public List<AlbumEntity> findByCategory(final Integer id) {
        return dao.findByCategory(id);
    }
}
