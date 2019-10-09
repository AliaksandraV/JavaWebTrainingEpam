package by.training.photographer.dao;

import java.sql.Connection;

public interface DaoFactory {

    UserDao getUserDao(Connection connection);
}
