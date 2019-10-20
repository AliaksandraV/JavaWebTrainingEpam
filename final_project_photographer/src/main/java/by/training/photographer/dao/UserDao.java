package by.training.photographer.dao;

import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;

public interface UserDao extends BaseDao<Integer, UserEntity> {

    UserEntity findByEmailAndPassword(String email, String password) throws PersistenceException;
}
