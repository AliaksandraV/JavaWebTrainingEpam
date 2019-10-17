package by.training.photographer.service;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public class PhotoServiceImpl extends BaseServiceImpl<Integer, PhotoEntity> implements PhotoService {

    public PhotoServiceImpl(final DaoFactory daoFactory) {
        super(daoFactory);
    }

    // todo impl
    @Override
    public Integer create(final PhotoEntity entity) throws PersistenceException {
//        dao.create(entity);
        return null;
    }

    @Override
    public void update(final PhotoEntity entity) throws PersistenceException {
//        dao.update(entity);
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
//        dao.delete(id);
    }

    @Override
    public PhotoEntity findById(final Integer id) throws PersistenceException {
//        return dao.findById(id);
        return null;
    }

    @Override
    public List<PhotoEntity> findAll() throws PersistenceException {
//        return dao.findAll();
        return null;
    }
}
