package by.training.photographer.dao;

import by.training.photographer.entity.Entity;

import java.sql.Connection;

public abstract class BaseDaoImpl<K, T extends Entity> implements BaseDao<K, T> {

    private final Connection connection;

    protected BaseDaoImpl(final Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
