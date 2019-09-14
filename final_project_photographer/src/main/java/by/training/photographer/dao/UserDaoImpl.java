package by.training.photographer.dao;

import by.training.photographer.entity.Entity;

import java.sql.Connection;
import java.util.List;

public class UserDaoImpl extends Dao {


    public UserDaoImpl(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(final Entity entity) {

    }

    @Override
    public void update(final Entity entity) {

    }

    @Override
    public void delete(final Object id) {

    }

    @Override
    public void delete(final Entity entity) {

    }

    @Override
    public Entity findById(final Object id) {
        return null;
    }

    @Override
    public List FindAll() {
        return null;
    }
}
