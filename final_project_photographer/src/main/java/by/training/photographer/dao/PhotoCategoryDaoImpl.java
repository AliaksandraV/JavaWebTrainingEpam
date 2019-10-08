package by.training.photographer.dao;

import by.training.photographer.entity.Entity;
import by.training.photographer.entity.LocalizedTextEntity;
import by.training.photographer.entity.PhotoCategoryEntity;
import by.training.photographer.exception.PersistenceException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class PhotoCategoryDaoImpl extends BaseDaoImpl<Integer, PhotoCategoryEntity> implements PhotoCategoryDao {
    private static Logger logger = Logger.getLogger(PhotoCategoryDaoImpl.class);

    private static final String CREATE_QUERY = "INSERT INTO photo_category (cover_image_path, localized_name_id) VALUES (?, ?);";
    private static final String UPDATE_QUERY = "UPDATE `photo_category` SET `cover_image_path` = ?, `localized_name_id` = ? WHERE `id` = ?";
    private static final String DELETE_QUERY = "DELETE FROM `photo_category` WHERE `id` = ?";
    private static final String FIND_BY_ID_QUERY = "SELECT `id`, `cover_image_path`, `localized_name_id` FROM `photo_category` WHERE `id`= ?";
    private static final String FIND_ALL_QUERY = "SELECT `id`, `cover_image_path`, `localized_name_id` FROM `photo_category` ORDER BY `id`";

    @Override
    public Integer create(final PhotoCategoryEntity photoCategory) throws PersistenceException {
        try (PreparedStatement statement = initConnection().prepareStatement(CREATE_QUERY);
             ResultSet resultSet = createAndGenerateId(statement, photoCategory)) {

            return getGeneratedId(resultSet);
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private ResultSet createAndGenerateId(final PreparedStatement statement, final PhotoCategoryEntity category) throws SQLException {
        setStringParameterToStatement(statement, 1, category.getCoverImagePath());
        setIdParameterToStatement(statement, 2, category.getLocalizedName());

        statement.executeUpdate();

        return statement.getGeneratedKeys();
    }

    private void setIdParameterToStatement(final PreparedStatement statement, final int index, final Entity entity) throws SQLException {
        if (entity != null) {
            statement.setInt(index, entity.getId());
        } else {
            statement.setNull(index, Types.INTEGER);
        }
    }

    private void setStringParameterToStatement(final PreparedStatement statement, int index, final String str) throws SQLException {
        if (str != null) {
            statement.setString(index, str);
        } else {
            statement.setNull(index, Types.VARCHAR);
        }
    }

    private Integer getGeneratedId(ResultSet resultSet) throws SQLException, PersistenceException {
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            logger.error("There is no auto incremented index after trying to add record into table `photo_category`");
            throw new PersistenceException();
        }
    }

    @Override
    public void update(final PhotoCategoryEntity category) throws PersistenceException {
        try (PreparedStatement statement = initConnection().prepareStatement(UPDATE_QUERY)) {
            setStringParameterToStatement(statement, 1, category.getCoverImagePath());
            setIdParameterToStatement(statement, 2, category.getLocalizedName());
            statement.setInt(3, category.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException();
        }
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        try (PreparedStatement statement = initConnection().prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException();
        }
    }

    @Override
    public PhotoCategoryEntity findById(final Integer id) throws PersistenceException {
        try (PreparedStatement statement = initConnection().prepareStatement(FIND_BY_ID_QUERY);
             ResultSet resultSet = findById(statement, id)) {

            return resultSet.next() ? createCategory(resultSet) : null;
        } catch (SQLException e) {
            throw new PersistenceException();
        }
    }

    private ResultSet findById(final PreparedStatement statement, Integer id) throws SQLException {
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    @Override
    public List<PhotoCategoryEntity> findAll() throws PersistenceException {
        List<PhotoCategoryEntity> categories = new ArrayList<>();

        try (PreparedStatement statement = initConnection().prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                categories.add(createCategory(resultSet));
            }
        } catch (SQLException e) {
            throw new PersistenceException();
        }
        return categories;
    }


    private PhotoCategoryEntity createCategory(final ResultSet resultSet) throws SQLException {
        PhotoCategoryEntity category = new PhotoCategoryEntity();
        category.setId(resultSet.getInt("id"));

        String coverPath = resultSet.getString("cover_image_path");
        if (!resultSet.wasNull()) {
            category.setCoverImagePath(coverPath);
        }

        int nameId = resultSet.getInt("localized_name_id");
        if (!resultSet.wasNull()) {
            LocalizedTextEntity name = new LocalizedTextEntity();
            name.setId(nameId);
            category.setLocalizedName(name);
        }

        return category;
    }
}
