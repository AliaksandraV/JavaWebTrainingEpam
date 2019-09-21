package by.training.photographer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {

    public static Connection getConnection() throws SQLException {
        PropertiesReader properties = new PropertiesReader("config.properties");
        String url = properties.takeProperty("db.url");
        String user = properties.takeProperty("db.user");
        String pass =  properties.takeProperty("db.password");
        return DriverManager.getConnection(url, user, pass);
    }
}
