package by.training.photographer.service;

import by.training.photographer.dao.AlbumDao;
import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public class AlbumServiceImpl extends BaseServiceImpl<Integer, AlbumEntity> implements AlbumService {

    private final AlbumDao dao;

    public AlbumServiceImpl(final AlbumDao dao) {
        super(null);
        this.dao = dao;
    }

    @Override
    public Integer create(final AlbumEntity entity) throws PersistenceException {
        dao.create(entity);
        return null;
    }

    @Override
    public void update(final AlbumEntity entity) throws PersistenceException {
        dao.update(entity);
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        dao.delete(id);
    }

    @Override
    public AlbumEntity findById(final Integer id) throws PersistenceException {
        return dao.findById(id);
    }

    @Override
    public List<AlbumEntity> findAll() throws PersistenceException {
        return dao.findAll();
    }

    @Override
    public List<AlbumEntity> findByCategory(final Integer id) throws PersistenceException {
        return dao.findByCategory(id);
    }
}
