package by.training.photographer.dao;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CreateConection {


    @BeforeSuite
    public static Connection initConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/photographer";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "root");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(url, prop);
    }


}
