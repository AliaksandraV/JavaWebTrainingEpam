package by.training.photographer.dao;

import by.training.photographer.entity.LocalizedTextEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class LocalizedTextDaoImpl extends DaoImpl<Integer, LocalizedTextEntity> implements LocalizedTextDao {

    @Override
    public void create(final LocalizedTextEntity text) {
        String sql = "INSERT INTO localized_text (russian) VALUES (?);";
        try (PreparedStatement statement = initConnection().prepareStatement(sql)) {
            initFields(statement, text);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(final LocalizedTextEntity text) {
        String sql = "UPDATE `localized_text` SET `russian` = ? WHERE `id` = ?";
        try (PreparedStatement statement = initConnection().prepareStatement(sql)) {
            initFields(statement, text);
            statement.setInt(2, text.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(final Integer id) {
        String sql = "DELETE FROM `localized_text` WHERE `id` = ?";
        try (PreparedStatement statement = initConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LocalizedTextEntity findById(final Integer id) {
        String sql = "SELECT `id`, `cover_image_path`, `localized_name_id` FROM `photo_category` WHERE `id`= ?";
        LocalizedTextEntity text = new LocalizedTextEntity();
        try (PreparedStatement statement = initConnection().prepareStatement(sql);
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
        return null;
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
