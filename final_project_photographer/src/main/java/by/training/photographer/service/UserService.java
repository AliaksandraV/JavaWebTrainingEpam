package by.training.photographer.service;

import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;

public interface UserService extends BaseService<Integer, UserEntity> {

    Integer register(String email, String password, String name, String phone) throws PersistenceException;

    UserEntity findByEmailAndPassword(String email, String password) throws PersistenceException;
}
