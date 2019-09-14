package by.training.photographer.dao;

import by.training.photographer.entity.PhotoEntity;

import java.util.List;

public interface PhotoDao {

    void add(PhotoEntity photo);

    void update(PhotoEntity photo);

    void delete(long id);

    PhotoEntity get(long id);

    List<PhotoEntity> list();
}
