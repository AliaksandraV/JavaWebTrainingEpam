package by.training.photographer.dao;

import by.training.photographer.entity.LikeEntity;

import java.util.List;

public interface LikeDao extends BaseDao<Integer, LikeEntity> {

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
