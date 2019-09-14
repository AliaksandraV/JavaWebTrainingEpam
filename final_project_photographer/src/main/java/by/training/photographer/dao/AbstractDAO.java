package by.training.photographer.dao;

import by.training.photographer.entity.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDAO<K, T extends Entity> {

    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract void create(T entity);

    public abstract void update(T entity);

    public abstract void delete(K id);

    public abstract void delete(T entity);

    public abstract T findById(K id);

    public abstract List<T> FindAll();

    public void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            // TODO: лог о невозможности закрытия Statement
        }
    }


}
