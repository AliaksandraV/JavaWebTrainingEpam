package by.training.photographer.service;

import by.training.photographer.entity.LikeEntity;

import java.util.List;

public interface LikeService extends Service<Integer, LikeEntity> {

    @Override
    void create(LikeEntity entity);

    @Override
    void update(LikeEntity entity);

    @Override
    void delete(Integer id);

    @Override
    LikeEntity findById(Integer id);

    @Override
    List<LikeEntity> findAll();
}
