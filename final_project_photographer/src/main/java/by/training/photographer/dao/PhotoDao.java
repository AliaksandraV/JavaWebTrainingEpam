package by.training.photographer.dao;

import by.training.photographer.entity.PaginationResult;
import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.exception.PersistenceException;

public interface PhotoDao extends BaseDao<Integer, PhotoEntity> {

    PaginationResult<PhotoEntity> findByAlbum(Integer albumId,final int currentPage, final int stepAmount) throws PersistenceException;
}
