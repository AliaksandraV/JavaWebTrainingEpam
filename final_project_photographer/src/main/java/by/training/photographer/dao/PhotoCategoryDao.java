package by.training.photographer.dao;

import by.training.photographer.entity.PhotoCategoryEntity;

import java.util.List;

public interface PhotoCategoryDao {
    void add(PhotoCategoryEntity photoCategory);

    void update(PhotoCategoryEntity photoCategory);

    void delete(long id);

    PhotoCategoryEntity get(long id);

    List<PhotoCategoryEntity> list();
}
