package by.training.photographer.service;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.dao.PhotoDao;
import by.training.photographer.dao.PhotoDaoImpl;
import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public class PhotoServiceImpl extends BaseServiceImpl<Integer, PhotoEntity> implements PhotoService {

    private PhotoDao dao = new PhotoDaoImpl(null);

    protected PhotoServiceImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public Integer create(final PhotoEntity entity) throws PersistenceException {
        dao.create(entity);
        return null;
    }

    @Override
    public void update(final PhotoEntity entity) throws PersistenceException {
        dao.update(entity);
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        dao.delete(id);
    }

    @Override
    public PhotoEntity findById(final Integer id) throws PersistenceException {
        return dao.findById(id);
    }

    @Override
    public List<PhotoEntity> findAll() throws PersistenceException {
        return dao.findAll();
    }
}
