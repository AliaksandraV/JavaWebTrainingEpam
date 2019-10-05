package by.training.photographer.dao;

import by.training.photographer.entity.PhotoCategoryEntity;

import java.util.List;

public interface PhotoCategoryDao extends BaseDao<Integer, PhotoCategoryEntity> {

    public abstract void create(PhotoCategoryEntity photoCategory);

    public abstract void update(PhotoCategoryEntity photoCategory);

    public abstract void delete(Integer id);

    public abstract PhotoCategoryEntity findById(Integer id);

    public abstract List<PhotoCategoryEntity> findAll();
}
