package by.training.photographer.dao;

import by.training.photographer.entity.UserEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void create(final UserEntity user) {
        String sql = "INSERT INTO user (`email`, `password`, `name`, `phone_number`, `role`) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement statement = null;
        try {
            StatementCreator statementCreator = new StatementCreator();
//            statement = statementCreator.takeStatement(sql);

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getPhone_number());
            statement.setInt(5, user.getRole());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();

            }
        }
    }

    @Override
    public void update(final UserEntity user) {
        String sql = "UPDATE `user` SET `email` = ?, `password` = ?, `name` = ?, `phone_number` = ?, `role` = ? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            StatementCreator statementCreator = new StatementCreator();
//            statement = statementCreator.takeStatement(sql);

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getPhone_number());
            statement.setInt(5, user.getRole());

            statement.setInt(6, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();

            }
        }
    }

    @Override
    public void delete(final Integer id) {
        String sql = "DELETE FROM `user` WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            StatementCreator statementCreator = new StatementCreator();
//            statement = statementCreator.takeStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public UserEntity findById(final Integer id) {
        String sql = "SELECT `id`, `email`, `password`, `name`, `phone_number`, `role` FROM `user` WHERE `id`= ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            StatementCreator statementCreator = new StatementCreator();
//            statement = statementCreator.takeStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            UserEntity user = null;
            if (resultSet.next()) {
                user = new UserEntity();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setPhone_number(resultSet.getString("phone_number"));
                user.setRole(resultSet.getInt("role"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
        return null;
    }

    @Override
    public List<UserEntity> findAll() {
        //        `email`, `password`, `name`, `phone_number`, `role`
        String sql = "SELECT `id`, `email`, `password`, `name`, `phone_number`, `role` FROM `user` ORDER BY `email`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            StatementCreator statementCreator = new StatementCreator();
//            statement = statementCreator.takeStatement(sql);
            resultSet = statement.executeQuery();
            List<UserEntity> users = new ArrayList<>();
            UserEntity user = null;
            while (resultSet.next()) {
                user = new UserEntity();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setPhone_number(resultSet.getString("phone_number"));
                user.setRole(resultSet.getInt("role"));

                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
        return null;
    }
}
