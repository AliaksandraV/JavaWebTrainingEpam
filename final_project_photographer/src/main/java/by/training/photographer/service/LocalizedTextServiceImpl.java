package by.training.photographer.service;

import by.training.photographer.dao.LocalizedTextDao;
import by.training.photographer.dao.LocalizedTextDaoImpl;
import by.training.photographer.entity.LocalizedTextEntity;

import java.util.List;

public class LocalizedTextServiceImpl implements LocalizedTextService {

    private LocalizedTextDao dao = new LocalizedTextDaoImpl();

    @Override
    public void create(final LocalizedTextEntity entity) {
        dao.create(entity);
    }

    @Override
    public void update(final LocalizedTextEntity entity) {
        dao.update(entity);
    }

    @Override
    public void delete(final Integer id) {
        dao.delete(id);
    }

    @Override
    public LocalizedTextEntity findById(final Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<LocalizedTextEntity> findAll() {
        return dao.findAll();
    }
}
