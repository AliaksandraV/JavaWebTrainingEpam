package by.training.photographer.service;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.dao.LocalizedTextDao;
import by.training.photographer.dao.connection.Transaction;
import by.training.photographer.entity.LocalizedTextEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public class LocalizedTextServiceImpl extends BaseServiceImpl<Integer, LocalizedTextEntity> implements LocalizedTextService {

    public LocalizedTextServiceImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public Integer create(final LocalizedTextEntity entity) throws PersistenceException {
        Transaction transaction = createTransaction();
        LocalizedTextDao dao = getLocalizedTextDao(transaction);

        return transaction.commitWithResult(() -> dao.create(entity));
    }

    @Override
    public void update(final LocalizedTextEntity entity) throws PersistenceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        throw new UnsupportedOperationException();

    }

    @Override
    public LocalizedTextEntity findById(final Integer id) throws PersistenceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<LocalizedTextEntity> findAll() throws PersistenceException {
        throw new UnsupportedOperationException();
    }

    private LocalizedTextDao getLocalizedTextDao(final Transaction transaction) throws PersistenceException {
        return getDaoFactory().getLocalizedTextDao(transaction.getConnection());
    }
}
