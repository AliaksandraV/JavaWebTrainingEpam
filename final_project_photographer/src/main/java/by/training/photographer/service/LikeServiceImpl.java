package by.training.photographer.service;

import by.training.photographer.dao.LikeDao;
import by.training.photographer.dao.LikeDaoImpl;
import by.training.photographer.entity.LikeEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public class LikeServiceImpl implements LikeService {

    private LikeDao dao = new LikeDaoImpl(null);

    @Override
    public void create(final LikeEntity entity) throws PersistenceException {
        dao.create(entity);
    }

    @Override
    public void update(final LikeEntity entity) throws PersistenceException {
        dao.update(entity);
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        dao.delete(id);
    }

    @Override
    public LikeEntity findById(final Integer id) throws PersistenceException {
        return dao.findById(id);
    }

    @Override
    public List<LikeEntity> findAll() throws PersistenceException {
        return dao.findAll();
    }
}
