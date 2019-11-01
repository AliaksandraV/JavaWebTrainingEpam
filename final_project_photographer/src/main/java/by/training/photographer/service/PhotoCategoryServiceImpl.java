package by.training.photographer.service;

import by.training.photographer.dao.AlbumDao;
import by.training.photographer.dao.DaoFactory;
import by.training.photographer.dao.PhotoCategoryDao;
import by.training.photographer.dao.connection.Transaction;
import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.PhotoCategoryEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public class PhotoCategoryServiceImpl extends BaseServiceImpl<Integer, PhotoCategoryEntity> implements PhotoCategoryService {

    public PhotoCategoryServiceImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public Integer create(final PhotoCategoryEntity entity) throws PersistenceException {
        Transaction transaction = createTransaction();
        PhotoCategoryDao dao = getCategoryDao(transaction);
        return transaction.commitWithResult(() -> dao.create(entity));
    }

    @Override
    public void update(final PhotoCategoryEntity entity) throws PersistenceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public PhotoCategoryEntity findById(final Integer id) throws PersistenceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<PhotoCategoryEntity> findAll() throws PersistenceException {
        Transaction transaction = createTransaction();
        PhotoCategoryDao dao = getCategoryDao(transaction);
        AlbumDao albumDao = getAlbumDao(transaction);

        List<PhotoCategoryEntity> categories = transaction.commitWithResult(dao::findAll);

        for (PhotoCategoryEntity category : categories) {
            List<AlbumEntity> albums = transaction.commitWithResult(() -> albumDao.findByCategory(category.getId()));
            category.setAlbumList(albums);
        }

        return categories;
    }

    private PhotoCategoryDao getCategoryDao(final Transaction transaction) throws PersistenceException {
        return getDaoFactory().getCategoryDao(transaction.getConnection());
    }

    private AlbumDao getAlbumDao(final Transaction transaction) throws PersistenceException {
        return getDaoFactory().getAlbumDao(transaction.getConnection());
    }

}
