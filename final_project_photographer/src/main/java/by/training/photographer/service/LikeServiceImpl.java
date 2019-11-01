package by.training.photographer.service;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.dao.LikeDao;
import by.training.photographer.dao.LikeDaoImpl;
import by.training.photographer.entity.LikeEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public class LikeServiceImpl extends BaseServiceImpl<Integer, LikeEntity> implements LikeService {

    private LikeDao dao = new LikeDaoImpl(null);

    protected LikeServiceImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public Integer create(final LikeEntity entity) throws PersistenceException {
       throw new UnsupportedOperationException();
    }

    @Override
    public void update(final LikeEntity entity) throws PersistenceException {
        throw new UnsupportedOperationException();

    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public LikeEntity findById(final Integer id) throws PersistenceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<LikeEntity> findAll() throws PersistenceException {
        throw new UnsupportedOperationException();
    }
}
