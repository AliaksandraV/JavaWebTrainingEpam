package by.training.photographer.service;

import by.training.photographer.dao.PhotoDao;
import by.training.photographer.dao.PhotoDaoImpl;
import by.training.photographer.entity.PhotoEntity;

import java.util.List;

public class PhotoServiceImpl implements PhotoService {

    private PhotoDao dao = new PhotoDaoImpl();

    @Override
    public void create(final PhotoEntity entity) {
        dao.create(entity);
    }

    @Override
    public void update(final PhotoEntity entity) {
        dao.update(entity);
    }

    @Override
    public void delete(final Integer id) {
        dao.delete(id);
    }

    @Override
    public PhotoEntity findById(final Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<PhotoEntity> findAll() {
        return dao.findAll();
    }
}
