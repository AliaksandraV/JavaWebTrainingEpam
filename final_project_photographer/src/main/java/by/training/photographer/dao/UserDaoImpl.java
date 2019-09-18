package by.training.photographer.dao;

import by.training.photographer.entity.UserEntity;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DaoImpl<Integer, UserEntity> implements UserDao {
    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    private static final String CREATE = "INSERT INTO user (`email`, `password`, `name`, `phone_number`, `role`) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE `user` SET `email` = ?, `password` = ?, `name` = ?, `phone_number` = ?, `role` = ? WHERE `id` = ?";
    private static final String DELETE = "DELETE FROM `user` WHERE `id` = ?";
    private static final String FIND_BY_ID = "SELECT `id`, `email`, `password`, `name`, `phone_number`, `role` FROM `user` WHERE `id`= ?";
    private static final String FIND_ALL = "SELECT `id`, `email`, `password`, `name`, `phone_number`, `role` FROM `user` ORDER BY `email`";

    @Override
    public void create(final UserEntity user) {
        try (PreparedStatement statement = initConnection().prepareStatement(CREATE)) {
            initFields(statement, user);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        PreparedStatement statement = null;
//        try {
//            StatementCreator statementCreator = new StatementCreator();
////            statement = statementCreator.takeStatement(sql);
//
//            statement.setString(1, user.getEmail());
//            statement.setString(2, user.getPassword());
//            statement.setString(3, user.getName());
//            statement.setString(4, user.getPhone_number());
//            statement.setInt(5, user.getRole());
//
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//                e.printStackTrace();
//
//            }
//        }
    }


    @Override
    public void update(final UserEntity user) {
        try (PreparedStatement statement = initConnection().prepareStatement(UPDATE)) {
            initFields(statement, user);
            statement.setInt(6, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        PreparedStatement statement = null;
//        try {
//            StatementCreator statementCreator = new StatementCreator();
////            statement = statementCreator.takeStatement(sql);
//
//            statement.setString(1, user.getEmail());
//            statement.setString(2, user.getPassword());
//            statement.setString(3, user.getName());
//            statement.setString(4, user.getPhone_number());
//            statement.setInt(5, user.getRole());
//
//            statement.setInt(6, user.getId());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//                e.printStackTrace();
//
//            }
//        }
    }

    @Override
    public void delete(final Integer id) {
        try (PreparedStatement statement = initConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        PreparedStatement statement = null;
//        try {
//            StatementCreator statementCreator = new StatementCreator();
////            statement = statementCreator.takeStatement(sql);
//            statement.setInt(1, id);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//            }
//        }
    }

    @Override
    public UserEntity findById(final Integer id) {
        UserEntity user = new UserEntity();
        try (PreparedStatement statement = initConnection().prepareStatement(FIND_BY_ID);
             ResultSet resultSet = createResultSet(statement, id)) {
            if (resultSet.next()) {
                createUser(resultSet, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        try {
//            StatementCreator statementCreator = new StatementCreator();
////            statement = statementCreator.takeStatement(sql);
//            statement.setInt(1, id);
//            resultSet = statement.executeQuery();
//            UserEntity user = null;
//            if (resultSet.next()) {
//                user = new UserEntity();
//                user.setId(resultSet.getInt("id"));
//                user.setEmail(resultSet.getString("email"));
//                user.setPassword(resultSet.getString("password"));
//                user.setName(resultSet.getString("name"));
//                user.setPhone_number(resultSet.getString("phone_number"));
//                user.setRole(resultSet.getInt("role"));
//            }
//            return user;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//            }
//        }
//        return null;
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> users = new ArrayList<>();
        try (PreparedStatement statement = initConnection().prepareStatement(FIND_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                UserEntity user = new UserEntity();
                users.add(createUser(resultSet, user));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
        //        `email`, `password`, `name`, `phone_number`, `role`
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        try {
//            StatementCreator statementCreator = new StatementCreator();
////            statement = statementCreator.takeStatement(sql);
//            resultSet = statement.executeQuery();
//            List<UserEntity> users = new ArrayList<>();
//            UserEntity user = null;
//            while (resultSet.next()) {
//                user = new UserEntity();
//                user.setId(resultSet.getInt("id"));
//                user.setEmail(resultSet.getString("email"));
//                user.setPassword(resultSet.getString("password"));
//                user.setName(resultSet.getString("name"));
//                user.setPhone_number(resultSet.getString("phone_number"));
//                user.setRole(resultSet.getInt("role"));
//
//                users.add(user);
//            }
//            return users;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//            }
//        }
//        return null;
    }

    private void initFields(final PreparedStatement statement, final UserEntity user) throws SQLException {
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getName());
        statement.setString(4, user.getPhone_number());
        statement.setInt(5, user.getRole());
    }

    private UserEntity createUser(final ResultSet resultSet, final UserEntity user) throws SQLException {
        user.setId(resultSet.getInt("id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setName(resultSet.getString("name"));
        user.setPhone_number(resultSet.getString("phone_number"));
        user.setRole(resultSet.getInt("role"));
        return user;
    }

}
