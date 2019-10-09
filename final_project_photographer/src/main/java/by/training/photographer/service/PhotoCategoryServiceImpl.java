package by.training.photographer.service;

import by.training.photographer.dao.LocalizedTextDao;
import by.training.photographer.dao.LocalizedTextDaoImpl;
import by.training.photographer.dao.PhotoCategoryDao;
import by.training.photographer.dao.PhotoCategoryDaoImpl;
import by.training.photographer.entity.LocalizedTextEntity;
import by.training.photographer.entity.PhotoCategoryEntity;
import by.training.photographer.exception.PersistenceException;

import java.util.List;

public class PhotoCategoryServiceImpl implements PhotoCategoryService {

    private PhotoCategoryDao dao = new PhotoCategoryDaoImpl(null);

    @Override
    public void create(final PhotoCategoryEntity entity) throws PersistenceException {
        dao.create(entity);
    }

    @Override
    public void update(final PhotoCategoryEntity entity) throws PersistenceException {
        dao.update(entity);
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        dao.delete(id);
    }

    @Override
    public PhotoCategoryEntity findById(final Integer id) throws PersistenceException {
        return dao.findById(id);
    }

    @Override
    public List<PhotoCategoryEntity> findAll() throws PersistenceException {
        List<PhotoCategoryEntity> categories = dao.findAll();
        for (PhotoCategoryEntity category: categories){
            LocalizedTextDao textDao = new LocalizedTextDaoImpl(null);
            int id = category.getLocalizedName().getId();
            LocalizedTextEntity name = textDao.findById(id);
            category.setLocalizedName(name);
        }

        return categories;
    }
}
