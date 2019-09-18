package by.training.photographer.dao;

import by.training.photographer.entity.LocalizedTextEntity;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class LocalizedTextDaoImpl extends DaoImpl<Integer, LocalizedTextEntity> implements LocalizedTextDao {
    private static Logger logger = Logger.getLogger(LocalizedTextDaoImpl.class);

    private static final String CREATE = "INSERT INTO localized_text (russian) VALUES (?);";
    private static final String UPDATE = "UPDATE localized_text SET russian = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM localized_text WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT id, russian FROM localized_text WHERE id= ?";
    private static final String FIND_ALL = "SELECT id, russian FROM localized_text ORDER BY id";


    @Override
    public void create(final LocalizedTextEntity text) {
        try (PreparedStatement statement = initConnection().prepareStatement(CREATE)) {
            initFields(statement, text);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(final LocalizedTextEntity text) {
        try (PreparedStatement statement = initConnection().prepareStatement(UPDATE)) {
            initFields(statement, text);
            statement.setInt(2, text.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(final Integer id) {
        try (PreparedStatement statement = initConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LocalizedTextEntity findById(final Integer id) {
        LocalizedTextEntity text = new LocalizedTextEntity();
        try (PreparedStatement statement = initConnection().prepareStatement(FIND_BY_ID);
             ResultSet resultSet = createResultSet(statement, id)) {
            if (resultSet.next()) {
                createLocalizedText(resultSet, text);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return text;
    }

    @Override
    public List<LocalizedTextEntity> findAll() {
        List<LocalizedTextEntity> texts = new ArrayList<>();
        try (PreparedStatement statement = initConnection().prepareStatement(FIND_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                LocalizedTextEntity text = new LocalizedTextEntity();
                texts.add(createLocalizedText(resultSet, text));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return texts;
    }

    private void initFields(final PreparedStatement statement, final LocalizedTextEntity text) throws SQLException {
        if (text.getRussian() != null) {
            statement.setString(1, text.getRussian());
        } else {
            statement.setNull(1, Types.VARCHAR);
        }
    }

    private LocalizedTextEntity createLocalizedText(final ResultSet resultSet, final LocalizedTextEntity text) throws SQLException {
        text.setId(resultSet.getInt("id"));

        String russian = resultSet.getString("cover_image_path");
        if (!resultSet.wasNull()) {
            text.setRussian(russian);
        }

        return text;
    }
}
