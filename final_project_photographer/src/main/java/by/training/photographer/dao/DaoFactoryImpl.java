package by.training.photographer.dao;

import java.sql.Connection;

public class DaoFactoryImpl implements DaoFactory {

    @Override
    public UserDao getUserDao(Connection connection) {
        return new UserDaoImpl(connection);
    }
}
