package by.training.photographer.dao;

import by.training.photographer.entity.PaginationResult;
import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public interface PhotoDao extends BaseDao<Integer, PhotoEntity> {

    PaginationResult<PhotoEntity> findByAlbumWithPagination(Integer albumId, final int currentPage, final int stepAmount) throws PersistenceException;

    List<PhotoEntity> findByAlbum(Integer albumId) throws PersistenceException;
}
