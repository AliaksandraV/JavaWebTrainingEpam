package by.training.photographer.service;

import by.training.photographer.dao.UserDao;
import by.training.photographer.dao.UserDaoImpl;
import by.training.photographer.entity.UserEntity;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public void create(final UserEntity entity) {
        dao.create(entity);
    }

    @Override
    public void update(final UserEntity entity) {
        dao.update(entity);
    }

    @Override
    public void delete(final Integer id) {
        dao.delete(id);
    }

    @Override
    public UserEntity findById(final Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return dao.findAll();
    }
}
