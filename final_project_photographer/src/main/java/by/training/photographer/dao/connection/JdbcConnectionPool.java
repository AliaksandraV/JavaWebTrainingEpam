package by.training.photographer.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JdbcConnectionPool {

    private List<Connection> availableConnections = new ArrayList<>();

    public JdbcConnectionPool() {
        initializeConnectionPool();
    }

    private void initializeConnectionPool() {
        while (!checkIfConnectionPoolIsFull()) {
            availableConnections.add(createNewConnectionForPool());
        }
    }

    private synchronized boolean checkIfConnectionPoolIsFull() {
        final int MAX_POOL_SIZE = Configuration.getInstance().DB_MAX_CONNECTIONS;
        return availableConnections.size() >= MAX_POOL_SIZE;
    }

    //Creating a connection
    private Connection createNewConnectionForPool() {
        Configuration config = Configuration.getInstance();
        try {
            Class.forName(config.DB_DRIVER);
            Connection connection = DriverManager.getConnection(config.DB_URL, config.DB_USER_NAME, config.DB_PASSWORD);
            connection.setAutoCommit(false);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Connection getConnectionFromPool() {
        Connection connection = null;
        if (!availableConnections.isEmpty()) {
            connection = availableConnections.get(0);
            availableConnections.remove(0);
        }
        return connection;
    }

    public synchronized void returnConnectionToPool(Connection connection) {
        availableConnections.add(connection);
    }

    // todo destroy method etc
}
