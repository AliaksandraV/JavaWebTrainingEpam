package by.training.photographer.dao.connection;

import by.training.photographer.exception.PersistenceException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ConnectionPool {

    private static final Logger logger = Logger.getLogger(ConnectionPool.class);

    private final List<Connection> availableConnections = new ArrayList<>();
    private final List<Connection> usedConnections = new ArrayList<>();

    private final Lock connectionsLock = new ReentrantLock();

    ConnectionPool() {
    }

    void initializeConnectionPool() throws PersistenceException {
        connectionsLock.lock();

        try {
            int maxPoolSize = DatabaseConfiguration.getInstance().getMaxConnections();

            while (availableConnections.size() < maxPoolSize) {
                availableConnections.add(createNewConnectionForPool());
            }
        } finally {
            connectionsLock.unlock();
        }
    }

    private Connection createNewConnectionForPool() throws PersistenceException {
        DatabaseConfiguration config = DatabaseConfiguration.getInstance();

        try {
            Class.forName(config.getDriverClass());
            Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
            connection.setAutoCommit(false);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            logger.fatal("It is impossible to initialize connection pool", e);
            throw new PersistenceException(e);
        }
    }

    Connection getConnectionFromPool() throws PersistenceException {
        connectionsLock.lock();

        try {
            Connection connection;

            if (!availableConnections.isEmpty()) {
                connection = availableConnections.get(0);
                availableConnections.remove(0);
            } else {
                logger.error("The limit of number of database connections is exceeded");
                throw new PersistenceException();
            }

            usedConnections.add(connection);

            return connection;
        } finally {
            connectionsLock.unlock();
        }
    }

    void returnConnectionToPool(Connection connection) {
        connectionsLock.lock();

        try {
            DatabaseConfiguration config = DatabaseConfiguration.getInstance();

            if (connection.isValid(config.getMaxCheckConnectionTimeout())) {
                connection.clearWarnings();
                availableConnections.add(connection);
                usedConnections.remove(connection);
            }
        } catch (SQLException e1) {
            logger.warn("It is impossible to return database connection into pool", e1);

            try {
                connection.close();
            } catch (SQLException e2) {
                // do nothing
            }
        } finally {
            connectionsLock.unlock();
        }
    }

    private void destroy() {
        connectionsLock.lock();

        try {
            usedConnections.addAll(availableConnections);
            availableConnections.clear();

            for (Connection connection : usedConnections) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // do nothing
                }
            }

            usedConnections.clear();
        } finally {
            connectionsLock.unlock();
        }
    }

    @Override
    protected void finalize() {
        destroy();
    }
}
