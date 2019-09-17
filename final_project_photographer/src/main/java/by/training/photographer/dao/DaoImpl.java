package by.training.photographer.dao;

import by.training.photographer.entity.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class DaoImpl<K, T extends Entity> implements Dao<K, T> {

    public Connection initConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/photographer";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "root");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(url, prop);
    }

//    @Override
//    public void create(final T entity) {
//        PreparedStatement statement = null;
//        try {
//
//            doCreate(statement, entity);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//                e.printStackTrace();
//
//            }
//        }
//    }
//
//    @Override
//    public void update(final T entity) {
//        PreparedStatement statement = null;
//        try {
//
//            doUpdate(statement, entity);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//                e.printStackTrace();
//
//            }
//        }
//    }
//
//
//    @Override
//    public void delete(final K id) {
//        PreparedStatement statement = null;
//        try {
//            doDelete(statement, id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//            }
//        }
//    }
//
//    @Override
//    public T findById(final K id) {
//        PreparedStatement statement = null;
//        T entity = null;
//        try {
//            entity = doSearchById(statement, id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//            }
//        }
//        return entity;
//    }
//
//
//    @Override
//    public List<T> findAll() {
//        PreparedStatement statement = null;
//        List<T> entities = new ArrayList<>();
//        try {
//            entities = doSearchAll(statement);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//            }
//        }
//        return entities;
//    }
//
//    protected abstract void doCreate(PreparedStatement statement, final T entity) throws SQLException;
//
//    protected abstract void doUpdate(final PreparedStatement statement, final T entity) throws SQLException;
//
//    protected abstract void doDelete(final PreparedStatement statement, final K id) throws SQLException;
//
//    protected abstract T doSearchById(final PreparedStatement statement, final K id) throws SQLException;
//
//    protected abstract List<T> doSearchAll(final PreparedStatement statement) throws SQLException;

}
