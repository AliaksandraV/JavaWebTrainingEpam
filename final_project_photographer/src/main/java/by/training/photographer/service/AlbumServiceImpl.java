package by.training.photographer.service;

import by.training.photographer.dao.AlbumDao;
import by.training.photographer.dao.DaoFactory;
import by.training.photographer.dao.connection.Transaction;
import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public class AlbumServiceImpl extends BaseServiceImpl<Integer, AlbumEntity> implements AlbumService {

    public AlbumServiceImpl(final DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public Integer create(final AlbumEntity entity) throws PersistenceException {
        Transaction transaction = createTransaction();
        AlbumDao dao = getAlbumDao(transaction);

        return transaction.commitWithResult(() -> dao.create(entity));
    }

    @Override
    public void update(final AlbumEntity entity) throws PersistenceException {
        Transaction transaction = createTransaction();
        AlbumDao dao = getAlbumDao(transaction);

        transaction.commit(() -> dao.update(entity));
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        Transaction transaction = createTransaction();
        AlbumDao dao = getAlbumDao(transaction);

        transaction.commit(() -> dao.delete(id));
    }

    @Override
    public AlbumEntity findById(final Integer id) throws PersistenceException {
        Transaction transaction = createTransaction();
        AlbumDao dao = getAlbumDao(transaction);

        return transaction.commitWithResult(() -> dao.findById(id));
    }

    @Override
    public List<AlbumEntity> findAll() throws PersistenceException {
        Transaction transaction = createTransaction();
        AlbumDao dao = getAlbumDao(transaction);

        return transaction.commitWithResult(dao::findAll);
    }

    @Override
    public List<AlbumEntity> findByCategory(final Integer categoryId) throws PersistenceException {
        Transaction transaction = createTransaction();
        AlbumDao dao = getAlbumDao(transaction);

        return transaction.commitWithResult(() -> dao.findByCategory(categoryId));
    }

    private AlbumDao getAlbumDao(Transaction transaction) throws PersistenceException {
        return getDaoFactory().getAlbumDao(transaction.getConnection());
    }
}
