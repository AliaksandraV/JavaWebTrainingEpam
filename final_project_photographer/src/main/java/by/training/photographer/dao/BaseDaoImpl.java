package by.training.photographer.dao;

import by.training.photographer.entity.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class BaseDaoImpl<K, T extends Entity> implements BaseDao<K, T> {

    private final Connection connection;

    protected BaseDaoImpl(final Connection connection) {
        this.connection = connection;
    }

    public Connection initConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/photographer";
        Properties prop = new Properties();
        prop.put("user", "editor");
        prop.put("password", "Aa123+");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(url, prop);
    }

    public Connection getConnection() {
        return connection;
    }
}
