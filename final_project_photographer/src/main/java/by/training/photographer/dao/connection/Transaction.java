package by.training.photographer.dao.connection;

import by.training.photographer.exception.PersistenceException;

import java.sql.Connection;
import java.sql.SQLException;

public class Transaction {

    private Connection connection;

    public <R> R commitWithResult(final CallbackWithResult<R> callback) throws PersistenceException {
        try {
            R result = callback.execute();
            connection.commit();
            DataSource.returnConnection(connection);
            return result;
        } catch (PersistenceException e) {
            try {
                connection.rollback();
                DataSource.returnConnection(connection);
            } catch (SQLException ex) {
                throw new PersistenceException(ex);
            }
            throw e;
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    public void commit(final Callback callback) throws PersistenceException {
        commitWithResult(() -> {
            callback.execute();
            return null;
        });
    }

    public Connection getConnection() throws PersistenceException {
        if (connection == null) {
            connection = DataSource.getConnection();
        }
        return connection;
    }

    public interface CallbackWithResult<R> {
        R execute() throws PersistenceException;
    }

    public interface Callback {
        void execute() throws PersistenceException;
    }
}
