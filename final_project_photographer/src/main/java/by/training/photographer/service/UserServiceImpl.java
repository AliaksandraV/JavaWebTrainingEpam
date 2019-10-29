package by.training.photographer.service;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.dao.UserDao;
import by.training.photographer.dao.connection.Transaction;
import by.training.photographer.entity.Role;
import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.util.PasswordUtils;

import java.util.List;

public class UserServiceImpl extends BaseServiceImpl<Integer, UserEntity> implements UserService {

    public UserServiceImpl(final DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public Integer create(final UserEntity entity) throws PersistenceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer register(final String email, String password, String name, String phone) throws PersistenceException {
        Transaction transaction = createTransaction();
        UserDao dao = getUserDao(transaction);

        String salt = generateSalt();
        String passwordHash = getPasswordHash(password, salt);

        UserEntity entity = new UserEntity(null, email, passwordHash, salt, name, phone, Role.USER);

        return transaction.commitWithResult(() -> dao.create(entity));
    }

    String generateSalt() {
        return PasswordUtils.getSalt();
    }

    String getPasswordHash(String password, String salt) {
        return PasswordUtils.generateSecurePassword(password, salt);
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

        UserEntity entity = transaction.commitWithResult(() -> dao.findByEmail(email));
        String salt = entity.getSalt();
        String passwordHash = entity.getPasswordHash();

        boolean passwordValid = isPasswordValid(password, salt, passwordHash);

        return passwordValid ? entity : null;
    }

    private boolean isPasswordValid(String password, String salt, String passwordHash) {
        return PasswordUtils.verifyUserPassword(password, passwordHash, salt);
    }
}
