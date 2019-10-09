package by.training.photographer.dao.connection;

import java.sql.Connection;

public class DataSource {

    private static JdbcConnectionPool pool = new JdbcConnectionPool();

    public static Connection getConnection() {
        return pool.getConnectionFromPool();
    }

    public static void returnConnection(Connection connection) {
        pool.returnConnectionToPool(connection);
    }
}
