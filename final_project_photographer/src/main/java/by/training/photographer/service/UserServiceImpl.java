package by.training.photographer.service;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.dao.UserDao;
import by.training.photographer.dao.connection.Transaction;
import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public class UserServiceImpl extends BaseServiceImpl<Integer, UserEntity> implements UserService {

    public UserServiceImpl(final DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public Integer create(final UserEntity entity) throws PersistenceException {
        Transaction transaction = createTransaction();
        UserDao dao = getUserDao(transaction);

        return transaction.commitWithResult(() -> dao.create(entity));
    }

    @Override
    public void update(final UserEntity entity) throws PersistenceException {
        Transaction transaction = createTransaction();
        UserDao dao = getUserDao(transaction);

        transaction.commit(() -> dao.update(entity));
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        Transaction transaction = createTransaction();
        UserDao dao = getUserDao(transaction);

        transaction.commit(() -> dao.delete(id));
    }

    @Override
    public UserEntity findById(final Integer id) throws PersistenceException {
        Transaction transaction = createTransaction();
        UserDao dao = getUserDao(transaction);

        return transaction.commitWithResult(() -> dao.findById(id));
    }

    @Override
    public List<UserEntity> findAll() throws PersistenceException {
        Transaction transaction = createTransaction();
        UserDao dao = getUserDao(transaction);

        return transaction.commitWithResult(dao::findAll);
    }

    private UserDao getUserDao(Transaction transaction) throws PersistenceException {
        return getDaoFactory().getUserDao(transaction.getConnection());
    }

    @Override
    public UserEntity findByEmailAndPassword(String email, String password) throws PersistenceException {
        Transaction transaction = createTransaction();
        UserDao dao = getUserDao(transaction);

        return transaction.commitWithResult(() -> dao.findByEmailAndPassword(email, password));
    }
}
