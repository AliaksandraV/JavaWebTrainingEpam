package by.training.photographer.service;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.dao.LocalizedTextDao;
import by.training.photographer.dao.LocalizedTextDaoImpl;
import by.training.photographer.entity.LocalizedTextEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public class LocalizedTextServiceImpl extends BaseServiceImpl<Integer, LocalizedTextEntity> implements LocalizedTextService {

    private LocalizedTextDao dao = new LocalizedTextDaoImpl(null);

    protected LocalizedTextServiceImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public Integer create(final LocalizedTextEntity entity) throws PersistenceException {
        dao.create(entity);
        return null;
    }

    @Override
    public void update(final LocalizedTextEntity entity) throws PersistenceException {
        dao.update(entity);
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        dao.delete(id);
    }

    @Override
    public LocalizedTextEntity findById(final Integer id) throws PersistenceException {
        return dao.findById(id);
    }

    @Override
    public List<LocalizedTextEntity> findAll() throws PersistenceException {
        return dao.findAll();
    }
}
