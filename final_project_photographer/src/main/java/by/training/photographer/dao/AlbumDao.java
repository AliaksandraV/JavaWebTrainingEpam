package by.training.photographer.dao;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public interface AlbumDao extends BaseDao<Integer, AlbumEntity> {

    List<AlbumEntity> findByCategory(Integer id) throws PersistenceException;
}
