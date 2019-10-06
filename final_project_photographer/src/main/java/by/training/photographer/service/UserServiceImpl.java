package by.training.photographer.service;

import by.training.photographer.dao.UserDao;
import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void create(final UserEntity entity) throws PersistenceException {
        dao.create(entity);
    }

    @Override
    public void update(final UserEntity entity) throws PersistenceException {
        dao.update(entity);
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        dao.delete(id);
    }

    @Override
    public UserEntity findById(final Integer id) throws PersistenceException {
        return dao.findById(id);
    }

    @Override
    public List<UserEntity> findAll() throws PersistenceException {
        return dao.findAll();
    }
}
