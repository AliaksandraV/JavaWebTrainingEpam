package by.training.photographer.dao;

import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;

public interface UserDao extends BaseDao<Integer, UserEntity> {

    UserEntity findByEmail(String email) throws PersistenceException;
}
