package by.training.photographer.dao;

import by.training.photographer.entity.LocalizedTextEntity;
import by.training.photographer.entity.PhotoCategoryEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class PhotoCategoryDaoImpl extends DaoImpl<Integer, PhotoCategoryEntity> implements PhotoCategoryDao {

    @Override
    public void create(final PhotoCategoryEntity photoCategory) {
        String sql = "INSERT INTO photo_category (cover_image_path, localized_name_id) VALUES (?, ?);";
        try (PreparedStatement statement = initConnection().prepareStatement(sql)) {
            initFields(statement, photoCategory);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(final PhotoCategoryEntity photoCategory) {
        String sql = "UPDATE `photo_category` SET `cover_image_path` = ?, `localized_name_id` = ? WHERE `id` = ?";
        try (PreparedStatement statement = initConnection().prepareStatement(sql)) {
            initFields(statement, photoCategory);
            statement.setInt(3, photoCategory.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(final Integer id) {
        String sql = "DELETE FROM `photo_category` WHERE `id` = ?";
        try (PreparedStatement statement = initConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PhotoCategoryEntity findById(final Integer id) {
        String sql = "SELECT `id`, `cover_image_path`, `localized_name_id` FROM `photo_category` WHERE `id`= ?";
        PhotoCategoryEntity category = new PhotoCategoryEntity();
        try (PreparedStatement statement = initConnection().prepareStatement(sql);
             ResultSet resultSet = createResultSet(statement, id)) {
            if (resultSet.next()) {
                createCategory(resultSet, category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }


    @Override
    public List<PhotoCategoryEntity> findAll() {
        String sql = "SELECT `id`, `localized_name_id` FROM `photo_category` ORDER BY `id`";
        List<PhotoCategoryEntity> categories = new ArrayList<>();
        try (PreparedStatement statement = initConnection().prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                PhotoCategoryEntity category = new PhotoCategoryEntity();
                categories.add(createCategory(resultSet, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    private void initFields(final PreparedStatement statement, final PhotoCategoryEntity category) throws SQLException {
        if (category.getCoverImagePath() != null) {
            statement.setString(1, category.getCoverImagePath());
        } else {
            statement.setNull(1, Types.VARCHAR);
        }

        if (category.getLocalizedName() != null) {
            statement.setInt(2, category.getLocalizedName().getId());
        } else {
            statement.setNull(2, Types.INTEGER);
        }
    }

    private PhotoCategoryEntity createCategory(final ResultSet resultSet, final PhotoCategoryEntity category) throws SQLException {

        category.setId(resultSet.getInt("id"));

        String coverPath = resultSet.getString("photo_category_id");
        if (!resultSet.wasNull()) {
            category.setCoverImagePath(coverPath);
        }

        Integer nameId = resultSet.getInt("localized_name_id");
        if (!resultSet.wasNull()) {
            LocalizedTextEntity name = new LocalizedTextEntity();
            name.setId(nameId);
            category.setLocalizedName(name);
        }

        return category;
    }
}
