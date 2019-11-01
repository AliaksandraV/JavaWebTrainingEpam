package by.training.photographer.service;

import by.training.photographer.entity.PaginationResult;
import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public interface PhotoService extends BaseService<Integer, PhotoEntity> {

    @Override
    Integer create(PhotoEntity entity) throws PersistenceException;

    @Override
    void update(PhotoEntity entity) throws PersistenceException;

    @Override
    void delete(Integer id) throws PersistenceException;

    @Override
    PhotoEntity findById(Integer id) throws PersistenceException;

    @Override
    List<PhotoEntity> findAll() throws PersistenceException;

    PaginationResult findByAlbumWithPagination(Integer albumId, int currentPage, int stepAmount) throws PersistenceException;

    List<PhotoEntity> findByAlbum(Integer albumId) throws PersistenceException;
}
