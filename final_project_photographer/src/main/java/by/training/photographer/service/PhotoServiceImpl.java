package by.training.photographer.service;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.dao.PhotoDao;
import by.training.photographer.dao.connection.Transaction;
import by.training.photographer.entity.PaginationResult;
import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public class PhotoServiceImpl extends BaseServiceImpl<Integer, PhotoEntity> implements PhotoService {

    public PhotoServiceImpl(final DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public Integer create(final PhotoEntity entity) throws PersistenceException {
        Transaction transaction = createTransaction();
        PhotoDao dao = getPhotoDao(transaction);

        return transaction.commitWithResult(() -> dao.create(entity));
    }


    @Override
    public void update(final PhotoEntity entity) throws PersistenceException {
        Transaction transaction = createTransaction();
        PhotoDao dao = getPhotoDao(transaction);

        transaction.commit(() -> dao.update(entity));
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        Transaction transaction = createTransaction();
        PhotoDao dao = getPhotoDao(transaction);

        transaction.commit(() -> dao.delete(id));
    }

    @Override
    public PhotoEntity findById(final Integer id) throws PersistenceException {
        Transaction transaction = createTransaction();
        PhotoDao dao = getPhotoDao(transaction);

        return transaction.commitWithResult(() -> dao.findById(id));
    }

    @Override
    public List<PhotoEntity> findAll() throws PersistenceException {
        Transaction transaction = createTransaction();
        PhotoDao dao = getPhotoDao(transaction);

        return transaction.commitWithResult(dao::findAll);
    }

    @Override
    public List<PhotoEntity> findByAlbum(final Integer albumId) throws PersistenceException {
        Transaction transaction = createTransaction();
        PhotoDao dao = getPhotoDao(transaction);

        return transaction.commitWithResult(() -> dao.findByAlbum(albumId));
    }

    @Override
    public PaginationResult findByAlbumWithPagination(final Integer albumId, final int currentPage, final int stepAmount) throws PersistenceException {
        Transaction transaction = createTransaction();
        PhotoDao dao = getPhotoDao(transaction);

        return transaction.commitWithResult(() -> dao.findByAlbumWithPagination(albumId, currentPage, stepAmount));
    }

    private PhotoDao getPhotoDao(final Transaction transaction) throws PersistenceException {
        return getDaoFactory().getPhotoDao(transaction.getConnection());
    }

}
