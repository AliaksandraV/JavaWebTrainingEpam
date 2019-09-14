package by.training.photographer;

import by.training.photographer.entity.UserEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/photographer";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "root");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        Connection cn = null;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            cn = DriverManager.getConnection(url, prop);
            Statement st = null;
            try {
                st = cn.createStatement();
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("SELECT * FROM user");
                    List<UserEntity> lst = new ArrayList<>();
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String email = rs.getString(2);
                        String password = rs.getString(3);
                        String name = rs.getString(4);
                        String phone = rs.getString(5);
                        int role = rs.getInt(6);
                        lst.add(new UserEntity(id, email, password, name, phone, role));
                    }
                    if (lst.size() > 0) {
                        System.out.println(lst);
                    } else {
                        System.out.println("Not found");
                    }

                } finally {
                    if (rs != null) { // был ли создан ResultSet
                         rs.close();
                    } else {
                        System.err.println("ошибка во время чтения из БД");
                    }
                }
            } finally {
                if (st != null) {
                    st.close();
                } else {
                    System.err.println("Statement не создан");
                }
            }
        } catch (SQLException e) { // для 1-го блока try
            System.err.println("DB connection error: " + e);
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }
        }
    }
}
