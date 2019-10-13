package by.training.photographer.dao.connection;

import by.training.photographer.exception.PersistenceException;

import java.sql.Connection;

public class DataSource {

    private static ConnectionPool connectionPool = new ConnectionPool();

    private DataSource() {
    }

    public static void init() throws PersistenceException {
        connectionPool.initializeConnectionPool();
    }

    static Connection getConnection() throws PersistenceException {
        return connectionPool.getConnectionFromPool();
    }

    static void returnConnection(Connection connection) {
        connectionPool.returnConnectionToPool(connection);
    }
}
