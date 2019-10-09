package by.training.photographer.service;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.dao.UserDao;
import by.training.photographer.dao.connection.Transaction;
import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final DaoFactory daoFactory;

    public UserServiceImpl(final DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void create(final UserEntity entity) throws PersistenceException {
        Transaction transaction = new Transaction();
        UserDao dao = daoFactory.getUserDao(transaction.getConnection());

        transaction.commitWithResult(() -> dao.create(entity));
        // todo return id in the end
    }

    @Override
    public void update(final UserEntity entity) throws PersistenceException {
        Transaction transaction = new Transaction();
        UserDao dao = daoFactory.getUserDao(transaction.getConnection());

        transaction.commit(() -> dao.update(entity));
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        Transaction transaction = new Transaction();
        UserDao dao = daoFactory.getUserDao(transaction.getConnection());

        transaction.commit(() -> dao.delete(id));
    }

    @Override
    public UserEntity findById(final Integer id) throws PersistenceException {
        Transaction transaction = new Transaction();
        UserDao dao = daoFactory.getUserDao(transaction.getConnection());

        return transaction.commitWithResult(() -> dao.findById(id));
    }

    @Override
    public List<UserEntity> findAll() throws PersistenceException {
        Transaction transaction = new Transaction();
        UserDao dao = daoFactory.getUserDao(transaction.getConnection());

        return transaction.commitWithResult(dao::findAll);
    }
}
