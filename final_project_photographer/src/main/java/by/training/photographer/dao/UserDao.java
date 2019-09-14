package by.training.photographer.dao;

import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.entity.UserEntity;

import java.util.List;

public interface UserDao {

    void add(UserEntity user);

    void update(UserEntity user);

    void delete(long id);

    PhotoEntity get(long id);

    List<UserEntity> list();
}
