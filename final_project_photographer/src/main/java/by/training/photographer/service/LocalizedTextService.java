package by.training.photographer.service;

import by.training.photographer.entity.LocalizedTextEntity;

import java.util.List;

public interface LocalizedTextService extends Service<Integer, LocalizedTextEntity> {

    @Override
    void create(LocalizedTextEntity entity);

    @Override
    void update(LocalizedTextEntity entity);

    @Override
    void delete(Integer id);

    @Override
    LocalizedTextEntity findById(Integer id);

    @Override
    List<LocalizedTextEntity> findAll();
}
