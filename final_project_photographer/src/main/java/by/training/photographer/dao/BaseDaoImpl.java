package by.training.photographer.dao;

import by.training.photographer.entity.Entity;

import java.sql.*;
import java.util.Properties;

public abstract class BaseDaoImpl<K, T extends Entity> implements BaseDao<K, T> {

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

    protected ResultSet createResultSet(final PreparedStatement statement, Integer id) throws SQLException {
        statement.setInt(1, id);
        return statement.executeQuery();
    }
}
