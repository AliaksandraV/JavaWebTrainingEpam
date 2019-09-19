package by.training.photographer.service;

import by.training.photographer.dao.LikeDao;
import by.training.photographer.dao.LikeDaoImpl;
import by.training.photographer.entity.LikeEntity;

import java.util.List;

public class LikeServiceImpl implements LikeService {

    private LikeDao dao = new LikeDaoImpl();

    @Override
    public void create(final LikeEntity entity) {
        dao.create(entity);
    }

    @Override
    public void update(final LikeEntity entity) {
        dao.update(entity);
    }

    @Override
    public void delete(final Integer id) {
        dao.delete(id);
    }

    @Override
    public LikeEntity findById(final Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<LikeEntity> findAll() {
        return dao.findAll();
    }
}
