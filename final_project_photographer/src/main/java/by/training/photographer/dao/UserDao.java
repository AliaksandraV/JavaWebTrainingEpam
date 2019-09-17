package by.training.photographer.dao;

import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.entity.UserEntity;

import java.util.List;

public interface UserDao extends Dao<Integer, UserEntity> {

    public abstract void create(UserEntity user);

    public abstract void update(UserEntity user);

    public abstract void delete(Integer id);

    public abstract UserEntity findById(Integer id);

    public abstract List<UserEntity> findAll();

}
