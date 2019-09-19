package by.training.photographer.service;

import by.training.photographer.entity.UserEntity;

import java.util.List;

public interface UserService extends Service<Integer, UserEntity> {

    @Override
    void create(UserEntity entity);

    @Override
    void update(UserEntity entity);

    @Override
    void delete(Integer id);

    @Override
    UserEntity findById(Integer id);

    @Override
    List<UserEntity> findAll();
}
