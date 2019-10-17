package by.training.photographer.service;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.dao.PhotoCategoryDao;
import by.training.photographer.dao.connection.Transaction;
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


    //TODO implement
    @Override
    public void update(final PhotoCategoryEntity entity) throws PersistenceException {
//        dao.update(entity);
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
//        dao.delete(id);
    }

    @Override
    public PhotoCategoryEntity findById(final Integer id) throws PersistenceException {
//        return dao.findById(id);
        return null;
    }

    @Override
    public List<PhotoCategoryEntity> findAll() throws PersistenceException {
        Transaction transaction = createTransaction();
        PhotoCategoryDao dao = getCategoryDao(transaction);

        return transaction.commitWithResult(dao::findAll);
    }

    private PhotoCategoryDao getCategoryDao(final Transaction transaction) throws PersistenceException {
        return getDaoFactory().getCategoryDao(transaction.getConnection());
    }

}
