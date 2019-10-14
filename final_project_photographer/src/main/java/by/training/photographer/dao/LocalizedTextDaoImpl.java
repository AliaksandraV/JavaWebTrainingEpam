package by.training.photographer.dao;

import by.training.photographer.entity.LocalizedTextEntity;
import by.training.photographer.exception.PersistenceException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class LocalizedTextDaoImpl extends BaseDaoImpl<Integer, LocalizedTextEntity> implements LocalizedTextDao {
    private static Logger logger = Logger.getLogger(LocalizedTextDaoImpl.class);

    private static final String CREATE_QUERY = "INSERT INTO localized_text (russian) VALUES (?);";
    private static final String UPDATE_QUERY = "UPDATE localized_text SET russian = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM localized_text WHERE id = ?";
    private static final String FIND_BY_ID_QUERY = "SELECT id, russian FROM localized_text WHERE id= ?";
    private static final String FIND_ALL_QUERY = "SELECT id, russian FROM localized_text ORDER BY id";

    public LocalizedTextDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Integer create(final LocalizedTextEntity text) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
             ResultSet resultSet = createAndGenerateId(statement, text)) {

            return getGeneratedId(resultSet);
        } catch (SQLException e) {
            throw new PersistenceException();
        }
    }

    private ResultSet createAndGenerateId(final PreparedStatement statement, final LocalizedTextEntity text) throws SQLException {
        if (text.getRussian() != null) {
            statement.setString(1, text.getRussian());
        } else {
            statement.setNull(1, Types.VARCHAR);
        }

        statement.executeUpdate();

        return statement.getGeneratedKeys();
    }

    private Integer getGeneratedId(ResultSet resultSet) throws SQLException, PersistenceException {
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            logger.error("There is no auto incremented index after trying to add record into table `localized_text`");
            throw new PersistenceException();
        }
    }

    @Override
    public void update(final LocalizedTextEntity text) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_QUERY)) {
            if (text.getRussian() != null) {
                statement.setString(1, text.getRussian());
            } else {
                statement.setNull(1, Types.VARCHAR);
            }
            statement.setInt(2, text.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException();
        }
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException();
        }
    }

    @Override
    public LocalizedTextEntity findById(final Integer id) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_ID_QUERY);
             ResultSet resultSet = findById(statement, id)) {

            return resultSet.next() ? createLocalizedTextEntity(resultSet) : null;
        } catch (SQLException e) {
            throw new PersistenceException();
        }
    }

    private ResultSet findById(final PreparedStatement statement, Integer id) throws SQLException {
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    @Override
    public List<LocalizedTextEntity> findAll() throws PersistenceException {
        List<LocalizedTextEntity> texts = new ArrayList<>();

        try (PreparedStatement statement = getConnection().prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                texts.add(createLocalizedTextEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new PersistenceException();
        }

        return texts;
    }

    private LocalizedTextEntity createLocalizedTextEntity(final ResultSet resultSet) throws SQLException {
        LocalizedTextEntity text = new LocalizedTextEntity();

        text.setId(resultSet.getInt("id"));
        String russian = resultSet.getString("russian");
        if (!resultSet.wasNull()) {
            text.setRussian(russian);
        }

        return text;
    }
}
