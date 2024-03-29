package by.training.photographer.dao;

import by.training.photographer.entity.Role;
import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.exception.UserDuplicateException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<Integer, UserEntity> implements UserDao {
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    private static final String CREATE_QUERY = "INSERT INTO user (`email`, `password_hash`, `salt`, `name`, `phone_number`, `role`) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_QUERY = "UPDATE `user` SET `email` = ?, `password_hash` = ?, `salt` = ?, `name` = ?, `phone_number` = ? WHERE `id` = ?";
    private static final String UPDATE_SHORT_QUERY = "UPDATE `user` SET `email` = ?, `name` = ?, `phone_number` = ? WHERE `id`= ?";
    private static final String DELETE_QUERY = "DELETE FROM `user` WHERE `id` = ?";
    private static final String FIND_BY_ID_QUERY = "SELECT `id`, `email`, `password_hash`, `salt`, `name`, `phone_number`, `role` FROM `user` WHERE `id`= ?";
    private static final String FIND_BY_EMAIL = "SELECT `id`, `email`, `password_hash`, `salt`, `name`, `phone_number`, `role` FROM `user` WHERE `email`= ?";
    private static final String FIND_ALL_QUERY = "SELECT `id`, `email`, `password_hash`, `salt`, `name`, `phone_number`, `role` FROM `user` ORDER BY `email`";

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Integer create(final UserEntity user) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
             ResultSet resultSet = createAndGenerateId(statement, user)) {

            return getGeneratedId(resultSet);
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                throw new UserDuplicateException(e);
            } else {
                throw new PersistenceException(e);
            }
        }
    }

    private ResultSet createAndGenerateId(final PreparedStatement statement, final UserEntity user) throws SQLException {
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getPasswordHash());
        statement.setString(3, user.getSalt());
        statement.setString(4, user.getName());
        statement.setString(5, user.getPhoneNumber());
        statement.setInt(6, user.getRole().getId());

        statement.executeUpdate();

        return statement.getGeneratedKeys();
    }

    private Integer getGeneratedId(ResultSet resultSet) throws SQLException, PersistenceException {
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            logger.error("There is no auto incremented index after trying to add record into table `user`");
            throw new PersistenceException();
        }
    }

    @Override
    public void update(final UserEntity user) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPasswordHash());
            statement.setString(3, user.getSalt());
            statement.setString(4, user.getName());
            statement.setString(5, user.getPhoneNumber());
            statement.setInt(6, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public UserEntity findById(final Integer id) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_ID_QUERY);
             ResultSet resultSet = findById(statement, id)) {

            return resultSet.next() ? createUserEntity(resultSet) : null;
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private ResultSet findById(final PreparedStatement statement, Integer id) throws SQLException {
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    @Override
    public List<UserEntity> findAll() throws PersistenceException {
        List<UserEntity> users = new ArrayList<>();

        try (PreparedStatement statement = getConnection().prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                users.add(createUserEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return users;
    }

    private UserEntity createUserEntity(final ResultSet resultSet) throws SQLException {
        UserEntity user = new UserEntity();

        user.setId(resultSet.getInt("id"));
        user.setEmail(resultSet.getString("email"));
        user.setPasswordHash(resultSet.getString("password_hash"));
        user.setSalt(resultSet.getString("salt"));
        user.setName(resultSet.getString("name"));
        user.setPhoneNumber(resultSet.getString("phone_number"));
        user.setRole(Role.getById(resultSet.getInt("role")));

        return user;
    }

    @Override
    public UserEntity findByEmail(String email) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_EMAIL);
             ResultSet resultSet = findByEmail(statement, email)) {

            return resultSet.next() ? createUserEntity(resultSet) : null;
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void update(int id, String email, String name, String phone) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_SHORT_QUERY)) {
            statement.setString(1, email);
            statement.setString(2, name);
            statement.setString(3, phone);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                throw new UserDuplicateException(e);
            } else {
                throw new PersistenceException(e);
            }
        }
    }

    private ResultSet findByEmail(final PreparedStatement statement, String email) throws SQLException {
        statement.setString(1, email);
        return statement.executeQuery();
    }
}
